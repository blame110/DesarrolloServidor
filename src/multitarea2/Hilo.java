package multitarea2;

public class Hilo extends Thread {

	static long factorial = 1;

	// Cuando creamos el hilo le asignamos el nombre
	Hilo(String nombre) {
		this.setName(nombre);
	}

	public void run() {

		System.out.println("Inicial el hilo " + this.getName());
		for (int z = 0; z <= 100; z++)
			for (int j = 0; j <= 1000; j++) {
				for (int i = 0; i <= 100; i++) {
					factorial(i);
				}
			}
		System.out.println("Finaliza el hilo " + this.getName());

	}

	// Funcion factorial
	long factorial(int num) {

		factorial = 1;
		synchronized (this) {
			for (int i = 1; i <= num; i++) {

				factorial = factorial * i;

			}
		}

		return factorial;
	}

}
