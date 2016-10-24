package junio_13;

import java.io.BufferedReader;
import java.io.FileReader;

public class letter {
    static int x;

    static String val;

    static String buscado;

    static boolean buscando = false;

    static int esta;

    static int s;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new FileReader("letter.in"));

        String cant = in.readLine();

        String valor = in.readLine();
        buscado = valor;

        String sig = in.readLine();

        s = Integer.parseInt(sig);

        x = 0;
        generar(Integer.parseInt(cant), "", 0);
        System.out.println(x);
        System.out.println(val);

    }

    static boolean generar(int cant, String ant, int ini) {

        for (int i = ini; i < cant; i++) {
            if (!buscando)
                x++;
            esta--;
            if (esta == 0 && buscando) {
                val = ant + (char) (i + 'A');
                return true;
            }
            String aux = ant;
            aux += (char) (i + 'A');
            if (aux.compareTo(buscado) == 0 && !buscando) {
                buscando = true;
                esta = s;
            }

            if (generar(cant, aux, i + 1))
                return true;
        }
        return false;
    }
}
