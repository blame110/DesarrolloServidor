package gestionBD;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MostrarJugadores {

	static Connection connection = null;
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		
		/**Parametros de conexion*/
		   String bd = "hundir";
		   String usuario = "root";
		   String password = "toor";
		   String url = "jdbc:mysql://localhost/"+bd;
		   
		   //Edad del jugador
		   int edad=0;
		   //Cadena con la instruccion sql
		   String query ="";
		   //Definimos una variable statement para ejecutar las querys
		   Statement stmt;
		   //Definimos un PreparedStatement para la forma 2
		   PreparedStatement pstmt;
		   //Definimos un resulset para guardar los datos
		   ResultSet res;
		   
		   Scanner teclado = new Scanner(System.in);
		   
		   //Leemos la edad mínima de los juegadores
		   System.out.print("Introduce la edad mínima de los jugadores:");
		   edad=teclado.nextInt();
		   
		   //Forma 1
		  //query = "SELECT * FROM hundir.jugador WHERE edad>" + edad + ";";
		  
		  //Forma2 
		  query = "SELECT * FROM jugador WHERE edad>?;";
	   
		    try
		   {
		   //Comprobamos que el proyecto tiene el conector
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   //Conectamos con la base de datos
		   connection = DriverManager.getConnection(url, usuario, password);
		   
		   //Creamos el statement a raiz de la conexion
		   //Forma1 stmt = connection.createStatement();
		   pstmt = connection.prepareStatement(query);
		   
		   //Ejecutamos la query y guardamos el resultado en el resulset
		   //Forma1
		   //res = stmt.executeQuery(query);
		   
		   //Le añadimos la edad al preparedStatement
		   pstmt.setInt(1, edad);
		   //Ejecutamos el preparedStatement
		   res=pstmt.executeQuery();
		   /**
		    * @
		    */
		   //Mostramos los datos de los jugadores
		   //Mientras haya registros en el resulset
		   while (res.next())
		   {
			   
		   		 System.out.print(res.getString("idJugador") + " - ");
		   		 System.out.print(res.getString("nombre") + " - ");
		   		 System.out.print(res.getString("turno") + " - ");
		   		 System.out.print(res.getString("edad") + " - ");
		   		 System.out.println(res.getString("ranking"));
		   		   
		   }
		   
   
		   
		   
		   //Cerramos la conexion
		   //Forma1
		   //stmt.close();
		   pstmt.close();
		   connection.close();
		   
		   }
		   catch (ClassNotFoundException e)
		   {
			   e.printStackTrace();
			   System.out.println("No esta el conector en el proyecto");
		   }
		   catch (SQLException e)
		   {
			   e.printStackTrace();
			   System.out.println("Error al conectarse a la BD");
		   }
		
		
		
	}
	
	
	/**
	 * Esta Funcion realiza la suma de dos enteros
	 * @param x primer entero a sumar	
	 * @param y segundo entero a sumar
	 * @return el resultado
	 */
	public int suma(int x, int y)
	{
		return x+y;
	}

}
