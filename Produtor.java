package lab7;

public class Produtor implements Runnable{
	
	InsereERetiraElementos monitor;
	Integer elemento;
	

	/**
	 * @param monitor
	 * @param elemento
	 */
	public Produtor(InsereERetiraElementos monitor, Integer elemento) {
		this.monitor = monitor;
		this.elemento = elemento;
	}

	@Override
	public void run() {
		while(true) {
			try {
				monitor.insereElemento(elemento);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
