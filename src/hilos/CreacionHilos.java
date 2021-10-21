package hilos;

public class CreacionHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos 3 hilos
		PrimerHilo hilo1 = new PrimerHilo("hilo1");
		PrimerHilo hilo2 = new PrimerHilo("hilo2");
		PrimerHilo hilo3 = new PrimerHilo("hilo3");

		// Creamos los Runnables
		SegundoHiloRunnable hilo4run = new SegundoHiloRunnable(80);
		SegundoHiloRunnable hilo5run = new SegundoHiloRunnable(40);

		// Creamos los hilos a partir de los Runnable
		Thread hilo4 = new Thread(hilo4run);
		Thread hilo5 = new Thread(hilo5run);

		// Creamos hilosCalculadoras
		HiloCalculadora hilo6run = new HiloCalculadora("Primero", "suma");
		HiloCalculadora hilo7run = new HiloCalculadora("Segundo", "resta");
		HiloCalculadora hilo8run = new HiloCalculadora("Tercero", "multiplicacion");

		Thread hilo6 = new Thread(hilo6run);
		Thread hilo7 = new Thread(hilo7run);
		Thread hilo8 = new Thread(hilo8run);

		// Arrancamos los hilos
		// hilo1.start();
		// hilo2.start();
		// hilo3.start();
		// hilo4.start();
		// hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();

	}

}
