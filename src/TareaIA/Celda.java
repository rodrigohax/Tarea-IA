package TareaIA;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {

    //atributos
    public int X;
    public int Y;

    //nuevos atributos para manejar imagenes
    public char tipo;
    public BufferedImage jugador, obstaculo, camino, adversario,peaton,buzon;

    //constructor, inicializa los atributos
    public Celda(int x, int y, char tipo) {
        this.X = x;
        this.Y = y;
        this.tipo = tipo;
        try {
            jugador = ImageIO.read(new File("images/jugador.png"));
            //obstaculo = ImageIO.read(new File("images/obstaculo.png"));
            adversario = ImageIO.read(new File("images/adversario.png"));
            peaton = ImageIO.read(new File("images/peaton.png"));
            buzon = ImageIO.read(new File("images/buzon.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    //metodo para dibujar celda, hace uso de drawRect
    @Override
    public void paintComponent(Graphics g) {
        switch (tipo) {
            case JUGADOR:
                g.drawImage(jugador, X, Y, null);
                break;
            case OBSTACULO:
                g.drawImage(obstaculo, X, Y, this);
                break;
            case MUNDO:
                break;
            case AUTO:
                g.drawImage(adversario, X, Y, this);
                break;

            case BUZON:
                g.drawImage(buzon, X, Y, this);
                break;
            case PEATON:
                g.drawImage(peaton, X, Y, this);
        }
    }

    //si el click esta sobre la celda
    public boolean celdaSeleccionada(int xp, int yp) {
        return contains(new Point(xp, yp));
    }
}
