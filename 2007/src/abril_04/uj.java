
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
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
public class uj {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("uj.in"));

		while (true) {
			String linea = in.readLine();
			StringTokenizer gg = new StringTokenizer(linea, " ");
			int n = Integer.parseInt(gg.nextToken());
			int cd = Integer.parseInt(gg.nextToken());

			if (n == cd && n == 0)
				break;

			//int res=(int)Math.pow(n,cd);

			BigInteger res = new BigInteger(String.valueOf(n));

			res = res.pow(cd);

			System.out.println(res.toString());

		}

	}
}
