package multitarea2;

public class HiloRunnable implements Runnable {
	
	
	private long tiempoEspera;
	public String nombre= "";
	
	//EL constructor recibe el nombre que va a tener el hilo
	//Y el tiempo que va a esperar
	HiloRunnable(String nombre, long tiempo)
	{
		this.nombre = nombre;
		tiempoEspera= tiempo;
	}
	
	public void run()
	{
		System.out.println("Soy el hilo " + nombre + " me voy a dormir " + tiempoEspera/1000 + " segundos");
		try {
			//Esperamos el tiempo de espera
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Soy el hilo " + nombre + " Acabo de despertar ");
		
	}

}
