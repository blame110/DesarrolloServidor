package multitarea2;


public class LanzadorHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Creamos un hilo y le pasamos el nombre
		Hilo hiloInicial = new Hilo("HiloInicial");
		Hilo hiloInicial2 = new Hilo("HiloInicial2");
		HiloRunnable hiloRunnable = new HiloRunnable("Runnable",2);
		Hilo conjuntoHilos[] = new Hilo[10];
		
		//Para ejecutar el runnable creamos un thread a partir de el
		Thread hiloInicial3 = new Thread(hiloRunnable);
		
		//Arrancamos los hilos
		//hiloInicial.start();
		//hiloInicial2.start();
		//hiloInicial3.start();
		
		//Creamos y arrancamos los 10 hilos
		for (int i=0;i<=9;i++)
		{
			conjuntoHilos[i] = new Hilo("Hilo" + (i+1));
			
			
			if (i==3 || i==6)
				conjuntoHilos[i].setPriority(Thread.MAX_PRIORITY);
			
			conjuntoHilos[i].start();
		}
		

		
	}

}
