package mayo_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class pie {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("pie.in"));
        int n = Integer.parseInt(in.readLine());

        while (n != 0) {
            int mat[][] = new int[n + 1][n + 1];
            MAT = new int[n + 1][n + 1];

            for (int i = 0; i < n + 1; i++) {
                String l = in.readLine();
                StringTokenizer gg = new StringTokenizer(l, " ");
                for (int j = 0; j < n + 1; j++) {
                    mat[i][j] = Integer.parseInt(gg.nextToken());
                    MAT[i][j] = mat[i][j];
                }
            }
            int v[] = new int[n + 1];

            for (int i = 0; i < n + 1; i++)
                v[i] = 1;

            int x = resolver(mat, v, 0, false);

            for (int i = 0; i < n + 1; i++)
                v[i] = 0;

            v[0] = 1;

            //int y = resolver(mat, v, 3);

            System.out.println(x);

            n = Integer.parseInt(in.readLine());
        }
    }

    static int MAX = 10000000;

    static int MAT[][];

    static int resolver(int mat[][], int v[], int x, boolean ban) {
        int men = 10000000;
        int vv = v[x];
        v[x] = 0;

        if (listo(v)) {
            v[x] = vv;
            int v2[] = new int[v.length];
            v2[0] = 1;
            for (int i = 1; i < v2.length; i++)
                v2[i] = 0;
            if (!ban)
                return resolver(MAT, v2, x, true);
            else
                return 0;
        }

        for (int i = 0; i < v.length; i++) {
            if (i != x && mat[x][i] != MAX) {
                int cant = mat[x][i];
                mat[x][i] = MAX;
                if (cant < men && menor(mat[i]) < men) {
                    int aux = cant + resolver(mat, v, i, ban);
                    if (aux < men) {
                        men = aux;
                    }
                }
                mat[x][i] = cant;
            }
        }

        v[x] = vv;

        return men;
    }

    static int menor(int v[]) {
        int men = 10000000;
        for (int i = 0; i < v.length; i++)
            if (v[i] < men)
                men = v[i];
        return men;
    }

    static boolean listo(int v[]) {
        for (int i = 0; i < v.length; i++)
            if (v[i] == 1)
                return false;
        return true;
    }
}
