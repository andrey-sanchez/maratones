//falta validar lo de la suma
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

public class matriosh {

	static public class nodo {

		public nodo ant;

		public int val;

		public nodo() {
			ant = null;
			val = 0;
		}

		public nodo(int v) {
			ant = null;
			val = v;
		}

		public nodo agregar(int v, nodo este) {
			nodo n = new nodo();
			n.ant = this;
			n.val = v;
			return n;
		}

		public nodo ret_neg() {
			nodo aux = this;
			while (aux != null && aux.val >= 0)
				aux = aux.ant;

			return aux;
		}

		public nodo ret_pos() {
			nodo aux = this.ant;
			nodo sig = this;
			while (aux != null && aux.val >= 0) {
				sig = aux;
				aux = aux.ant;
			}

			return sig;
		}

		public void eliminar(int v) {
			nodo aux = this.ant;
			nodo a = this;
			while (aux != null && aux.val != v) {
				a = aux;
				aux = aux.ant;
			}

			if (aux != null) {
				a.ant = aux.ant;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("matriosh.in"));

		String linea = in.readLine();

		while (linea != null && linea.length() != 0) {

			StringTokenizer gg = new StringTokenizer(linea, " ");

			int tam = gg.countTokens();

			int val[] = new int[tam];
			nodo cab = null;
			for (int i = 0; i < tam; i++) {
				val[i] = Integer.parseInt(gg.nextToken());
				if (cab == null)
					cab = new nodo(val[i]);
				else
					cab = cab.agregar(val[i], cab);
			}
			boolean ban = true;

			while (ban) {

				if (cab == null)
					break;

				if (cab.val <= 0) {
					ban = false;
					break;
				}

				nodo abre = cab.ret_neg();

				if (abre == null) {
					ban = false;
					break;
				}

				nodo cierre = cab.ret_pos();

				if (Math.abs(cierre.val) != Math.abs(abre.val)) {
					ban = false;
					break;
				}
				cab.eliminar(abre.val);
				
				if (cierre == cab)
					cab = cab.ant;
				else
					cab.eliminar(cierre.val);

			}

			if (ban)
				System.out.println(":-) Matrioshka!");
			else
				System.out.println(":-( Try again.");

			linea = in.readLine();
		}

	}

	static boolean vacio(int v[]) {
		for (int i = 0; i < v.length; i++)
			if (v[i] != 0)
				return false;
		return true;
	}
}
