package hilos;

//Otra forma de implementar los hilos es extender la clase Runnable
//Es obligatorio implementar el metodo run
public class SegundoHiloRunnable implements Runnable {

	int numero;

	public SegundoHiloRunnable(int num) {
		this.numero = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < numero; i++) {
			/*
			 * try { Thread.sleep(500); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

			if (i % 2 == 0)
				System.out.println(i + "Es par");
		}

	}

}
