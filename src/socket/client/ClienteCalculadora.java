package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket sock;
		int opcionElegida = 0;
		int num1 = 0, num2 = 0;
		Scanner teclado = new Scanner(System.in);

		// Nos conectamos con el servidor
		try {
			sock = new Socket("localhost", socket.server.ServidorCalculadora.PORT);

			// Extraemos los streams de entrada y salida
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

			while (opcionElegida != 3) {

				if (opcionElegida == 1 || opcionElegida == 2) {
					// leemos los dos números
					System.out.print("introduce el numero1:");
					num1 = teclado.nextInt();
					System.out.print("introduce el numero2:");
					num2 = teclado.nextInt();

					// Y los dos números
					dos.writeInt(num1);
					dos.writeInt(num2);

					// Recibo el resultado del servidor
					if (opcionElegida == 1)
						System.out.println("La suma es:" + dis.readInt());

					if (opcionElegida == 2)
						System.out.println("La multiplicación es:" + dis.readInt());

				}

				// Mostramos el menu
				System.out.println("******************************************");
				System.out.println("************CALCULATOR********************");
				System.out.println("            1.SUMA");
				System.out.println("            2.MULTIPLICACIÓN");
				System.out.println("            3.SALIR");
				System.out.println("******************************************");
				// Leemos la opcion
				opcionElegida = teclado.nextInt();
				// Le mandamos la opción elegida
				dos.writeInt(opcionElegida);

			}

			// Cerramos el socket
			sock.close();
			teclado.close();
			dis.close();
			dos.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
