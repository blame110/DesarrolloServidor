package visual;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploVisual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	       // Crea un nuevo contenedor JFrame.
        JFrame jfrm=new JFrame("Una simple aplicaci�n Swing");

        // Se le da al cuadro un tama�o inicial.
        jfrm.setSize(475,200);

        // Termine el programa cuando el usuario cierre la aplicaci�n.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea una etiqueta basada en texto.
        JLabel jLabel= new JLabel("Programaci�n GUI con Swing.");

        // Agregue la etiqueta al panel de contenido (content pane).
        jfrm.add(jLabel);

        // Visualiza el marco.
        jfrm.setVisible(true);

	}

}
