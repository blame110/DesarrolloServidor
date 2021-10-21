package hilos;

public class EjemploPrioridades {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		PrimerHilo hilos[] = new PrimerHilo[10];

		// Creamos y arrancamos los hilos
		for (int i = 0; i <= 9; i++) {
			hilos[i] = new PrimerHilo("hilo" + i);

		}

		// Asigno prioridades Aleatorias
		hilos[3].setPriority(Thread.MAX_PRIORITY);

		hilos[8].setPriority(Thread.MAX_PRIORITY);

		hilos[4].setPriority(Thread.MIN_PRIORITY);

		// arrancamos los hilos
		for (int i = 0; i <= 9; i++) {

			hilos[i].start();

		}

	}

}
