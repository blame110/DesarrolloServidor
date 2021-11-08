package socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadora {

	// Puerto de conexion del servicio
	public static final int PORT = 1234;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Socket de la conexion
		Socket sockCliente = null;
		ServerSocket serSock = null;
		int opcionElegida = 0, num1 = 0, num2 = 0, resultado = 0;

		try {
			// Arrancamos el servicio
			serSock = new ServerSocket(PORT);

			// Escuchamos las peticiones de conexion
			sockCliente = serSock.accept();

			// Extraemos los streams de entrada y salida
			DataInputStream dis = new DataInputStream(sockCliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(sockCliente.getOutputStream());

			while (opcionElegida != 3) {
				// leemos la opción elegida
				opcionElegida = dis.readInt();

				// Si es un 2 o un 1 calculamos la operacion
				if (opcionElegida == 1 || opcionElegida == 2) {

					num1 = dis.readInt();
					num2 = dis.readInt();

					// Dependiendo de la opción elegida calculamos la operación
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

			// Cerramos los sockets
			sockCliente.close();
			serSock.close();
			dos.close();
			dis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
