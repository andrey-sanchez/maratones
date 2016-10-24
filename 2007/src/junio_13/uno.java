package junio_13;

import java.io.BufferedReader;
import java.io.FileReader;

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
public class uno {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new FileReader("uno.in"));

        String cad = in.readLine();

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {

            String c = in.readLine();
            boolean ban = false;
            for (int j = 2; j < c.length() - 2 && !ban; j++) {
                String a1 = c.substring(0, j);
                String a2 = c.substring(j + 1, c.length());

                if (cad.indexOf(a1) != -1 && cad.indexOf(a2) != -1) {
                    ban = true;
                }
            }

            if (ban)
                System.out.println(c);

        }

    }
}
