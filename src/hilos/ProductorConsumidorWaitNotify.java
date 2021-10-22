package hilos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProductorConsumidorWaitNotify {

	public static void main(String args[]) {

		System.out.println("Como usar el metodo wait y notify en Java");
		System.out.println("Resolviendo el problema del Productor-Consumidor");

		// Objeto compartido por el productor y el consumidor para
		// llenar o ir consumiendo respectivamente
		Queue buffer = new LinkedList<>();
		int maxSize = 10;

		Thread producer = new Productor(buffer, maxSize, "PRODUCER");
		Thread consumer = new Consumidor(buffer, maxSize, "CONSUMER");

		producer.start();
		consumer.start();
	}
}

class Productor extends Thread {
	private Queue queue;
	private int maxSize;

	public Productor(Queue queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				if (queue.size() == maxSize) {

					queue.notify();

					try {
						System.out.println(
								"La cola esta llena, el hilo productor esta esperando que el consumidor tome algo de la cola");
						// Si la cola esta llena me pongo a dormir
						// hasta que el consumidor me avise
						// Me avisara cuando haya vaciado la cola
						queue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				Random random = new Random();
				int i = random.nextInt();

				System.out.println("Produciendo valor : " + i);
				queue.add(i);

			}
		}
	}
}

class Consumidor extends Thread {
	private Queue queue;
	private int maxSize;

	public Consumidor(Queue queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {

				if (queue.isEmpty()) {
					queue.notify();
					System.out.println("La cola esta vacia,"
							+ "El hilo consumidor esta esperando que el hilo productor que ponga algo en la cola");
					try {
						// Si la cola esta vacia me pongo a esperar
						// hasta que el productor me despierte
						queue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				System.out.println("Consumiendo valor : " + queue.remove());

			}
		}
	}
}