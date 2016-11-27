
import java.io.BufferedReader;
import java.io.FileReader;

public class polygons {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("polygons.in"));
		String linea = in.readLine();
		while (linea.compareTo("0") != 0) {
			String v[] = linea.split(" ");
			poligono uno = new poligono();
			poligono dos = new poligono();

			
			uno.puntos = Integer.parseInt(v[0]);			
			uno.vector = new double[uno.puntos][2];
			int c = 0;
			for (int i = 0; i < (uno.puntos*2); i+=2) {
				uno.vector[c][0] = Integer.parseInt(v[i + 1]);
				uno.vector[c][1] = Integer.parseInt(v[i + 2]);
				c++;
				
			}
			linea = in.readLine();
			v = linea.split(" ");
			dos.puntos = Integer.parseInt(v[0]);			
			dos.vector = new double[dos.puntos][2];
			c = 0;
			for (int i = 0; i < (dos.puntos*2); i+=2) {
				dos.vector[c][0] = Integer.parseInt(v[i + 1]);
				dos.vector[c][1] = Integer.parseInt(v[i + 2]);
				c++;
			}
			double area1 = area(uno);
			double area2 = area(dos);

			poligono tres = new poligono();
			int cont = 0;
			tres.puntos = uno.puntos + dos.puntos;
			tres.vector = new double[tres.puntos][2];
			for (int i = 0; i < uno.puntos; i++) {
				if (puntos_dentro(uno.vector[i][0], uno.vector[i][1], dos)) {
					tres.vector[cont][0] = uno.vector[i][0];
					tres.vector[cont][1] = uno.vector[i][1];
					cont++;
				}
			}
			for (int i = 0; i < dos.puntos; i++) {
				if (puntos_dentro(dos.vector[i][0], dos.vector[i][1], uno)) {
					tres.vector[cont][0] = dos.vector[i][0];
					tres.vector[cont][1] = dos.vector[i][1];
					cont++;
				}
			}
			tres.puntos = cont;
			double area3 = area(tres);

			double total = (area1 + area2) - area3;
			System.out.println(total);
			linea = in.readLine();
		}
	}

	public static double signed_area(double a1, double a2, double b1,
			double b2, double c1, double c2) {
		return ((a1 * b2 - a2 * b1 + a2 * c1 - a1 * c2 + b1 * c2 - c1 * b2) / 2.0);
	}

	public static boolean ccw(double a1,double a2,double b1,double b2,double c1,double c2)
	{
		   return(signed_area(a1,a2,b1,b2,c1,c2)>0.0000001);
	}	
	public static double area(poligono x) {
		double total = 0;
		int j;
		for (int i = 0; i < x.puntos; i++) {
			j = (i + 1) % x.puntos;
			total += (x.vector[i][0] * x.vector[j][1])- (x.vector[j][0] * x.vector[i][1]);
		}
		return (total / 2);
	}

	public static boolean puntos_dentro(double x,double y,poligono p)
	{
		int n = p.puntos;
		for(int i = 0; i<p.puntos;i++)
		{
			if(ccw(p.vector[i][0],p.vector[i][1],p.vector[(i+1)/n][0],p.vector[(i+1)/n][1],x,y))
			{
				return false;
			}
		}
		return true;
	}

	public static class poligono {
		public int puntos;
		public double vector[][];
		poligono()
		{}
	}

}
