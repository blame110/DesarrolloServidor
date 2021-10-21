package hilos;

public class PrimerHilo extends Thread {
	int i = 0;

	// Hacemos un constructor que reciba el nombre del hilo y lo asigna
	public PrimerHilo(String nombre) {
		this.setName(nombre);
	}

	// Metodo que se lanza cuando arrancamos el hilo
	public void run() {
		for (i = 0; i <= 1000000; i++) {
			// System.out.println("Hilo " + this.getName() + ":" + i);
			int x = (int) (Math.random() * 1000);
			for (int j = 0; j < x; j++) {
				double resultado = Math.sqrt(j) * x;
			}

		}
		System.out.println(this.getName() + " ha finalizado");
	}

}
