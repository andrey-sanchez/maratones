
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 * Created on 21/04/2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author maraton
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class equidivisions {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(
				"equidivisions.in"));
		while (true) {
			String linea = in.readLine();

			int t = Integer.parseInt(linea);
			if (t == 0)
				break;

			int mat[][] = new int[t][t];

			for (int i = 0; i < t; i++)
				for (int j = 0; j < t; j++)
					mat[i][j] = t;

			for (int i = 1; i < t; i++) {
				linea = in.readLine();
				StringTokenizer gg = new StringTokenizer(linea);
				while (gg.hasMoreTokens()) {
					int f = Integer.parseInt(gg.nextToken());
					int c = Integer.parseInt(gg.nextToken());
					mat[f - 1][c - 1] = i;
				}
			}
			boolean res = true;
			for (int i = 1; i <= t && res == true; i++) {
				boolean ban = false;
				for (int f = 0; f < t && !ban; f++)
					for (int c = 0; c < t && !ban; c++) {
						if (mat[f][c] == i) {
							ban = true;
							int con = contar(mat, f, c, i, t);
							if (con != t) {
								res = false;
							}
						}
					}
			}

			if (res)
				System.out.println("good");
			else
				System.out.println("wrong");
		}

	}

	static int contar(int m[][], int f, int c, int ele, int tam) {

		if (f < 0 || f >= tam || c < 0 || c >= tam)
			return 0;
		if (m[f][c] != ele)
			return 0;

		m[f][c] = -1;

		int con = 1;

		//con += contar(m, f - 1, c - 1, ele, tam);
		con += contar(m, f, c - 1, ele, tam);
		//con += contar(m, f + 1, c - 1, ele, tam);
		con += contar(m, f - 1, c, ele, tam);
		con += contar(m, f + 1, c, ele, tam);
//		con += contar(m, f - 1, c + 1, ele, tam);
		con += contar(m, f, c + 1, ele, tam);
		//con += contar(m, f + 1, c + 1, ele, tam);

		return con;
	}
}
