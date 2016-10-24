package junio_13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/*
 * Created on 13/06/2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author maraton
 *         <p/>
 *         TODO To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public class partial {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new FileReader("partial.in"));

        String cad = in.readLine();
        int tam = 0;
        String may = "0";
        for (int i = cad.length(); i > tam; i--) {

            for (int j = 0; j < cad.length(); j++) {
                if (j + i <= cad.length()) {
                    String aux = cad.substring(j, j + i);
                    if (primo(aux)) {
                        if (tam == aux.length()) {
                            may = mayor(aux, may);
                        } else {
                            tam = aux.length();
                            may = aux;
                        }
                    }
                } else
                    break;
            }
        }

        if (tam == 0) {
            System.out.println("No Primes");
        } else
            System.out.println(may);
    }

    static String mayor(String a1, String a2) {

        int a11 = Integer.parseInt(a1);
        int a21 = Integer.parseInt(a2);

        if (a21 > a11)
            return a2;
        return a1;
    }

    static boolean primo(String n) {

        BigInteger big = new BigInteger(n);

        BigInteger cero = new BigInteger("0");
        BigInteger uno = new BigInteger("1");
        BigInteger dos = new BigInteger("2");
        BigInteger tres = new BigInteger("3");

        if (big.compareTo(uno) == 0 || big.compareTo(dos) == 0)
            return true;

        if (big.mod(dos).compareTo(cero) == 0)
            return false;

        for (BigInteger i = tres; i.compareTo(big) < 0; i = i.add(dos)) {
            if (big.mod(i).compareTo(cero) == 0)
                return false;
        }

        return true;

		/*
         * int aux = Integer.parseInt(n); if (aux == 1 || aux == 2) return true;
		 * if (aux % 2 == 0) return false; for (int i = 3; i < aux; i += 2) if
		 * (aux % i == 0) return false;
		 * 
		 * return true;
		 */
    }
}
