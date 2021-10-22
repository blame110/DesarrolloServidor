package hilos;

public class HiloCalculadora implements Runnable {

	static int resultado = 0;
	String operacion;

	public HiloCalculadora(String name, String operacion) {

		this.operacion = operacion;
		Thread.currentThread().setName(name);
	}

	private int sum;

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

	}

}
