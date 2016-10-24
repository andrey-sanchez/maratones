package junio_13;

import java.io.BufferedReader;
import java.io.FileReader;

public class word {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("word.in"));
        String cad = in.readLine();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String c = in.readLine();
            boolean ban = false;
            for (int j = 2; j < c.length() - 1 && !ban; j++) {
                String a1 = c.substring(0, j);
                String a2 = c.substring(j, c.length());

                if (cad.indexOf(a1) != -1 && cad.indexOf(a2) != -1
                        && a1.length() >= 2 && a2.length() >= 2) {
                    ban = true;
                }
            }
            if (ban)
                System.out.println(c);
        }
    }
}
