package mayo_05;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Created on 05/10/2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author maraton
 *         <p/>
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class primary {

    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new FileReader("primary.in"));
        String linea = in.readLine();

        while (linea.compareTo("0") != 0) {
            String sol = recursiva(linea, 0, "");
            System.out.println(linea + sol);
            linea = in.readLine();
        }
    }

    public static String recursiva(String val, int cont, String vec) {
        String solucion = "";
        int n = Integer.parseInt(val);
        int subfact[] = new int[val.length() * val.length()];
        int cont_subfact = 0;

        for (int i = 0; i < val.length(); i++) {
            for (int j = 0; j < val.length(); j++) {
                String va = val.substring(i, j);
                int nu = Integer.parseInt(va);
                if (n % nu == 0 && n != nu && nu != 0 && nu != 1) {
                    subfact[cont_subfact] = n;
                    cont_subfact++;
                }
            }
        }

        if (cont_subfact == 0) {
            return solucion;
        }
        cont++;
        String sin_factores[] = new String[cont_subfact];

        String series[] = new String[val.length() * val.length()];
        int cont_series = 0;

        for (int i = 0; i < cont_subfact; i++) {
            for (int j = 0; j < val.length(); j++) {
                String largo = String.valueOf(subfact[i]);

                if (String.valueOf(subfact[i]).compareTo(val.substring(j, j + largo.length())) == 0) {
                    String resto = val.substring(0, j) + val.substring(j, j + largo.length());
                    sin_factores[i] = resto;
                }
            }
        }
        for (int i = 0; i < cont_subfact; i++) {
            vec = recursiva(sin_factores[i], cont, vec + " " + sin_factores[i]);
            String vv[] = vec.split(" ");
            if (vv.length > max) {
                max = vv.length;
                solucion = vec;
            } else if (vv.length == max) {
                String aux[] = solucion.split(" ");
                for (int j = 0; j < vv.length; j++) {
                    int aux1 = Integer.parseInt(vv[j]);
                    int aux2 = Integer.parseInt(aux[j]);

                    if (aux1 < aux2) {
                        solucion = vv[j];
                    } else if (aux1 == aux2)
                        continue;
                    else
                        break;
                }
            }
        }
        return "";
    }
}
