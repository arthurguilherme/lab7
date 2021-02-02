/**
 * 
 */
package lab7;

/**
 * @author Arthur Guilherme Souza
 *
 */
public class InsereERetiraElementos {

	Integer[] buffer = new Integer[10];
	Integer count = 0, in = 0, out = 0; // variaveis de estado

	// inicia o buffer no construtor
	public InsereERetiraElementos() {
		for (int i = 0; i < 10; i++)
			buffer[i] = 0;
	}

	// insere Elemento no Buffer
	public synchronized void insereElemento(Integer elemento) throws InterruptedException {

	// tempo de espera menor para visualizarmos mais elementos inseridos
        Thread.sleep(100);

		System.out.println("P[" + in + "] quer inserir");
		while (count == 10) {
			System.out.println("P[" + in + "] bloqueou");
			wait();
			System.out.println("P[" + in + "] desbloqueou");
		}

		this.buffer[in] = elemento;
		this.in = (in + 1) % 10;
		this.count++;

		System.out.println("P[" + in + "] inseriu " + elemento);

		notifyAll();

	}

	// retira Elemento no Buffer
	public synchronized void retiraElemento() throws InterruptedException {

	// tempo de espera maior para visualizarmos mais elementos inseridos
        Thread.sleep(500);

		System.out.println("C[" + out + "] quer consumir");
		while (count == 0) {
			System.out.println("C[" + out + "] bloqueou");
			wait();
			System.out.println("C[" + out + "] desbloqueou");
		}

		Integer elemento = buffer[out];
		this.buffer[out] = 0;
		this.out = (out + 1) % 10;
		this.count--;

		System.out.println("P[" + in + "] consumiu " + elemento);

		notifyAll();

	}

	// imprime o Buffer
	public synchronized void imprimeBuffer() {
		for (int i = 0; i < 10; i++)
			System.out.print(buffer[i] + " ");
		System.out.println("");
	}
}
