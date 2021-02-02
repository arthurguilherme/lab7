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
	public static void main(String[] args) {

		// inicializa o Buffer com o monitor
		InsereERetiraElementos monitor = new InsereERetiraElementos();

		// cria as threads produtoras e consumidoras
		for (int i = 0; i < 4; i++) {
			new Thread(new Produtor(monitor, i)).start();
			new Thread(new Consumidor(monitor)).start();
		}
	}
}
