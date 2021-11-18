package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadoraLanzador {

	// Puerto de conexion del servicio
	public static final int PORT = 1234;
	public static boolean servidorEncendido = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Socket de la conexion
		Socket sockCliente = null;
		ServerSocket serSock = null;

		try {

			// Arrancamos el servicio
			serSock = new ServerSocket(PORT);

			while (servidorEncendido) {
				// Escuchamos las peticiones de conexion

				// Se conecta un cliente
				sockCliente = serSock.accept();
				
				//Para cada cliente Creamos un hilo que responde a lo que pida
				//Le pasamos el socket de la conexion
				ServidorCalculadoraThread hiloServidorCalculadora = new ServidorCalculadoraThread(sockCliente);
				
				//Arrancamos el hilo
				hiloServidorCalculadora.start();
			}

			// Cerramos los sockets
		
			serSock.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
