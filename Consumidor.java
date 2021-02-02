package lab7;

public class Consumidor implements Runnable {

	InsereERetiraElementos monitor;

	/**
	 * @param monitor
	 */
	public Consumidor(InsereERetiraElementos monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {
		while(true) {
			try {
				monitor.retiraElemento();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
