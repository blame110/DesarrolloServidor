package hilos;

public class HiloCalculadora implements Runnable {

	static int resultado = 0;
	String operacion;

	public HiloCalculadora(String name, String operacion) {

		this.operacion = operacion;
		Thread.currentThread().setName(name);
	}

	private int sum;

	// sumArray está sincronizado
	synchronized int sumArray(int nums[]) {
		sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println("Total acumulado de " + Thread.currentThread().getName() + " es " + sum);
			try {
				Thread.sleep(10);// permitir el cambio de tarea
			} catch (InterruptedException exc) {
				System.out.println("Hilo interrumpido");
			}
		}
		return sum;
	}

	public static synchronized void calculadora(String operacion) {

		for (int i = 1; i <= 20; i++) {

			// Generamos aleatoriamente los operandos
			int operando1 = (int) (Math.random() * 1000);
			int operando2 = (int) (Math.random() * 1000);

			switch (operacion.toLowerCase()) {
			case "suma":
				resultado = operando1 + operando2;
				break;
			case "resta":
				resultado = operando1 - operando2;
				break;
			case "multiplicacion":
				resultado = operando1 * operando2;
				break;

			}

			System.out.println(Thread.currentThread().getName() + " bucle:" + i + " y el resultado es " + resultado);
		}

	}

	public void run() {

		calculadora(operacion);

		try {
			// Esperamos a que llegue otro a fastidiar
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
