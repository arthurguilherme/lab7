package lab7;

import java.util.Random;

public class Produtor implements Runnable{
	
	InsereERetiraElementos monitor;
	Random geraElemento = new Random();
	

	/**
	 * @param monitor
	 */
	public Produtor(InsereERetiraElementos monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {
		while(true) {
			try {
				monitor.insereElemento(geraElemento.nextInt(8)+1);
				monitor.imprimeBuffer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
