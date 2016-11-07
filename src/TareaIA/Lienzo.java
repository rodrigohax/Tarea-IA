package TareaIA;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Timer;

public class Lienzo extends Canvas implements Constantes {

    public Laberinto laberinto;
    public Image fondo;
    public Graphics graficoBuffer;
    public Image imagenBuffer;
    public Auto auto, auto2, auto3;
    public Timer lanzadorTareas;
    public Jugador jugador;
    public Peaton peaton1, peaton2, peaton3, peaton4;

    public Lienzo() {
        laberinto = new Laberinto(this);

        auto = new Auto(laberinto, 29, 1);
        auto2 = new Auto(laberinto, 29, 7);
        auto3 = new Auto(laberinto, 29, 13);
        jugador = new Jugador(laberinto);

        peaton1 = new Peaton(laberinto, new Point(2, 2), new Point(18, 6));
        peaton2 = new Peaton(laberinto, new Point(8, 8), new Point(12, 12));

        peaton3 = new Peaton(laberinto, new Point(2, 6), new Point(8, 12));
        // peaton4 = new Peaton(laberinto,new Point(2,2),new Point(18,6));

        try {
            fondo = ImageIO.read(new File("images/fondo.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                jugador.moverCelda(evt);
                repaint();
            }
        });

        lanzadorTareas = new Timer();
        lanzadorTareas.scheduleAtFixedRate(auto, 0, 1000);
        lanzadorTareas.scheduleAtFixedRate(auto2, 0, 1500);
        lanzadorTareas.scheduleAtFixedRate(auto3, 0, 1100);
        lanzadorTareas.scheduleAtFixedRate(peaton1, 0, 2000);
        lanzadorTareas.scheduleAtFixedRate(peaton2, 0, 2200);
        lanzadorTareas.scheduleAtFixedRate(peaton3, 0, 100);
    }

    @Override
    public void update(Graphics g) {
        if (graficoBuffer == null) {
            imagenBuffer = createImage(this.getWidth(), this.getHeight());
            graficoBuffer = imagenBuffer.getGraphics();
        }
        graficoBuffer.setColor(getBackground());
        graficoBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
        graficoBuffer.drawImage(fondo, 0, 0, null);
        laberinto.update(graficoBuffer);
        g.drawImage(imagenBuffer, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }
}
