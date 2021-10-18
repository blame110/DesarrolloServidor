package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class ClienteCuadrado {
	public static void main(String args[]) {

		InetAddress direcc = null;
		try {
			// Comprobamos que existe el host
			direcc = InetAddress.getByName(args[0]);
		} catch (UnknownHostException uhe) {
			System.err.println("Host no encontrado : " + uhe);
			System.exit(-1);
		}

		// Puerto que hemos usado para el servidor
		int puerto = 1234;

		// Enviamos el n�mero
		Socket sckt = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			// Convertimos el texto en n�mero
			int numero = Integer.parseInt(args[1]);

			// Creamos el Socket
			sckt = new Socket(direcc, puerto);

			// Extraemos los streams de entrada y salida
			dis = new DataInputStream(sckt.getInputStream());
			dos = new DataOutputStream(sckt.getOutputStream());

			// Lo escribimos
			dos.writeInt(numero);

			// Leemos el resultado final
			long resultado = dis.readLong();

			// Indicamos en pantalla
			System.out.println("Solicitud = " + numero + "\tResultado = " + resultado);

			// y cerramos los streams y el socket
			dis.close();
			dos.close();

		} catch (Exception e) {
			System.err.println("Se ha producido la excepci�n : " + e);
		}
		try {
			if (sckt != null)
				sckt.close();
		} catch (IOException ioe) {
			System.err.println("Error al cerrar el socket :" + ioe);
		}
	}
}
