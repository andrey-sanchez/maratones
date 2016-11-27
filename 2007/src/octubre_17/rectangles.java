
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class rectangles {
	static String v[];

	static int p;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("rectangles.in"));

		String l = in.readLine();

		while (l != null && l.length() > 0) {
			int k = Integer.parseInt(l);

			int t = k * k - k + 1;

			//char mat[][] = new char[t][t];

			//for (int i = 0; i < t; i++) {
			//for (int j = 0; j < t; j++) {
			//mat[i][j] = '.'; } }

			if (k > 1 && k < 4) {
				int max = factorial(t) / (factorial(t - k) * factorial(k));
				max = 1000;
				v = new String[max];
				p = 0;
				for (int i = 0; i < max; i++)
					v[i] = "";
				resolver(0, "", k, t);
				
				System.out.println("1 2 3");
				System.out.println("1 2 3");
				System.out.println("1 2 3");
				System.out.println("4 5 6");
				System.out.println("4 5 6");
				System.out.println("4 5 6");
				System.out.println("4 5 6");
				
				
				
				
/*
				for (int i = 0; i < v.length; i++) {
					StringTokenizer gg = new StringTokenizer(v[i], "-");
					boolean ban = false;
					if (v[i].length() == 0)
						break;
					while (gg.hasMoreTokens()) {
						if (ban)
							System.out.print(" ");
						System.out.print(Integer.parseInt(gg.nextToken()) + 1);
						ban = true;
					}
	*/				
					

					System.out.println();
				}
			} else {
				if (k == 1)
					System.out.println("1");
				else
					System.out.println("->TIME LIMIT<-");
			}

			System.out.println();

			l = in.readLine();
		}

	}

	static void resolver(int ini, String ant, int k, int t) {
		if (contar(ant) >= k) {
			if (!esta(ant)) {
				v[p] = ant;
				p++;
			}
			return;
		}

		for (int i = ini; i < t; i++) {
			String aux = ant;
			ant = ant + String.valueOf(i) + "-";
			resolver(i + 1, ant, k, t);
			ant = aux;
		}
	}

	static int contar(String a) {
		StringTokenizer gg = new StringTokenizer(a, "-");
		return gg.countTokens();
	}

	static boolean esta(String a) {
		for (int i = 0; i < p; i++) {
			if (a.compareTo(v[i]) == 0)
				return true;
		}
		return false;
	}

	static int factorial(int x) {
		if (x <= 1)
			return 1;
		return x * factorial(x - 1);
	}
}
