package hilos;

import java.util.Scanner;

public class CampoDeTiro {
	public static void main(String[] args) {
		Pistola arma = new Pistola();
		Cargar c = new Cargar(arma);
		Descargar d = new Descargar(arma);
		c.start();
		d.start();
	}
}

class Pistola {

	private static boolean enposicion = true;

	public synchronized void disparar() {
		Scanner teclado = new Scanner(System.in);
		while (enposicion == false) {
			try {
				// Esperar a apuntar
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		enposicion = false;
		notifyAll();
	}

	public synchronized void apuntar() {
		while (enposicion == true) {
			try {
				// Esperar a disparar
				wait();
			} catch (InterruptedException e) {
			}
		}

		enposicion = true;
		notifyAll();
	}

}

class Cargar extends Thread {
	private Pistola arma;

	public Cargar(Pistola arma) {
		this.arma = arma;

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			arma.apuntar();
			System.out.println("Apuntar bala: " + i);
		}
	}
}

class Descargar extends Thread {
	private Pistola arma;

	public Descargar(Pistola arma) {
		this.arma = arma;

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			arma.disparar();
			System.out.println("Descargar  bala: " + i);
		}
	}
}