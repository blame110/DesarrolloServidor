package hilos;

public class EjemploJoin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		PrimerHilo hilos[] = new PrimerHilo[10];

		// Creamos y arrancamos los hilos
		for (int i = 0; i <= 9; i++) {
			hilos[i] = new PrimerHilo("hilo" + (i + 1));
			hilos[i].start();

		}

		// Forma de comprobar la finalización de todos los hilos
		boolean hilosTerminados = false;
		while (!hilosTerminados) {
			int numHilosFinalizados = 0;

			for (int i = 0; i <= 9; i++) {
				// Si el hilo esta finalizado incrementamos el contador
				// de hilos finalizados
				if (!hilos[i].isAlive()) {
					numHilosFinalizados++;
				}

			}
			// Si hay 10 hilos terminados finalizamos el bucle
			if (numHilosFinalizados == 10)
				hilosTerminados = true;

		}

		// Creamos y arrancamos los hilos
		for (int i = 0; i <= 9; i++) {
			hilos[i].join();
		}

		System.out.println("Acaba el programa principal");
		// Esperamos a que todos los hilos acaben con wait

	}

}
