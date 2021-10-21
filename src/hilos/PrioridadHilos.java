package hilos;

//Demostración de prioridades en hilos
class PrioridadHilos implements Runnable {
	int contar;
	Thread hilo;

	static boolean stop = false;
	static String actualNombre;

	// Construye un nuevo hilo.
	PrioridadHilos(String nombre) {
		hilo = new Thread(this, nombre);
		contar = 0;
		actualNombre = nombre;
	}

	// Punto de entrada de hilo.
	public void run() {
		System.out.println(hilo.getName() + " iniciando.");
		do {
			contar++;
			if (actualNombre.compareTo(hilo.getName()) != 0) {
				actualNombre = hilo.getName();
				System.out.println("En " + actualNombre);
			}
		} while (stop == false && contar < 10000000);
		stop = true;
		System.out.println("\n" + hilo.getName() + " terminado.");
	}
}
