package TareaIA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
//nuestra clase se compone de un lienzo de dibujo (herada de canvas)

    public Lienzo lienzo;
//constructor

    public VentanaPrincipal() {
        lienzo = new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo);
        this.setTitle("Tarea IA");
        this.setSize(970,500);
    }
}
