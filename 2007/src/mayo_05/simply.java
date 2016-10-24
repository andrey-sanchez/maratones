package mayo_05;

import java.io.BufferedReader;
import java.io.FileReader;

public class simply {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("simply.in"));
        String linea = in.readLine();

        while (linea != null && linea.length() != 0) {
            int tam = linea.length();

            linea = linea.replaceAll("C", "I");
            linea = linea.replaceAll("D", "I");
            linea = linea.replaceAll("E", "I");

            for (char i = 'p'; i <= 'z'; i++) {
                //char
                linea = linea.replaceAll(String.valueOf(i), "s");
            }

            boolean band = true;
            while (band) {
                band = false;
                if (linea.indexOf("Ns") != -1 || linea.indexOf("Iss") != -1)
                    band = true;
                linea = linea.replaceAll("Ns", "s");
                linea = linea.replaceAll("Iss", "s");

            }
            if (linea.length() != 1 || linea.charAt(0) != 's')
                System.out.println("NO");
            else
                System.out.println("YES");
            /*for (int i = 0; i < tam; i++) {

				if (linea.charAt(i) >= 'p' && linea.charAt(i) <= 'z') {
					if (i == 0)
						linea = "s" + linea.substring(i + 1, tam);
					else if (linea.charAt(i - 1) == 'N') {
						if (i + 1 < tam)
							linea = linea.substring(0, i - 1) + "s"
									+ linea.substring(i + 1, tam);
						else
							linea = linea.substring(0, i - 1) + "s";
						tam = linea.length();
						i = -1;
					} else if (linea.charAt(i - 1) == 'C'|| linea.charAt(i - 1) == 'D'|| linea.charAt(i - 1) == 'E'				|| linea.charAt(i - 1) == 'I') {
						if (i + 1 < tam)
							if (linea.charAt(i + 1) >= 'p'
									&& linea.charAt(i + 1) <= 'z') {
								if (i + 2 < tam)
									linea = linea.substring(0, i - 1) + "s"
											+ linea.substring(i + 2, tam);
								else
									linea = linea.substring(0, i - 1) + "s";
								tam = linea.length();
								i = -1;
							}
					}
				}
			}
			tam = linea.length();
			if (tam != 1)
				System.out.println("NO");
			else
				System.out.println("YES");*/
            linea = in.readLine();
        }
    }
}
