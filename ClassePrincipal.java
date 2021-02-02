/**
 * 
 */
package lab7;

/**
 * @author Arthur Guilherme Souza
 *
 */
public class ClassePrincipal {

	/**
	 * @param args
	 */
	static int nP = 4, nC = 4; // pode variar aqui os valores do numero de threads Produtoras e consumidoras
	
	public static void main(String[] args) {

		// inicializa o Buffer com o monitor
		InsereERetiraElementos monitor = new InsereERetiraElementos();

		// cria as threads produtoras e consumidoras
		for (int i = 0; i < nP; i++) {
			new Thread(new Produtor(monitor)).start();
		}
		for (int i = 0; i < nC; i++) {
			new Thread(new Produtor(monitor)).start();
		}
		
	}
}
