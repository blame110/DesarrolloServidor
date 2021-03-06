package socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadoraThread extends Thread {

	// Puerto de conexion del servicio
	public static final int PORT = 1234;
	private Socket sockCliente;

	//El constructor recibe un socket para poderse comunicar con su cliente
	ServidorCalculadoraThread (Socket sockCliente){
		this.sockCliente = sockCliente;
	}
	
	public void run() {
		// TODO Auto-generated method stub

		int opcionElegida = 0, num1 = 0, num2 = 0, resultado = 0;
		
		

		try {
			// Extraemos los streams de entrada y salida
			DataInputStream dis = new DataInputStream(sockCliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(sockCliente.getOutputStream());

			while (opcionElegida != 3) {
				// leemos la opci?n elegida
				opcionElegida = dis.readInt();

				// Si es un 2 o un 1 calculamos la operacion
				if (opcionElegida == 1 || opcionElegida == 2) {

					num1 = dis.readInt();
					num2 = dis.readInt();

					// Dependiendo de la opci?n elegida calculamos la operaci?n
					switch (opcionElegida) {
					case 1:
						resultado = num1 + num2;
						break;
					case 2:
						resultado = num1 * num2;
						break;
					}

					// Le devolvemos el resultado al cliente
					dos.writeInt(resultado);
				}

			}

		
			dos.close();
			dis.close();
			sockCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
