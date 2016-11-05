package TareaIA;

import java.awt.Graphics;
import javax.swing.JComponent;

public class Laberinto extends JComponent implements Constantes {

    public Celda[][] celdas;
    public Celda celdaMovimiento;
    public Lienzo lienzoPadre;
    public Jugador jugador;

    public Laberinto(Lienzo lienzoPadre) {
        celdas = new Celda[ANCHO][ALTO];
        
        initMundo();

        insertarObstaculo(3, 6, 3, 6);
        insertarObstaculo(9, 12, 3, 6);
        insertarObstaculo(15, 18, 3, 6);
        insertarObstaculo(21, 24, 3, 6);
        insertarObstaculo(27, 30, 3, 6);

        insertarObstaculo(3, 6, 9, 12);
        insertarObstaculo(9, 12, 9, 12);
        insertarObstaculo(15, 18, 9, 12);
        insertarObstaculo(21, 24, 9, 12);
        insertarObstaculo(27, 30, 9, 12);

        this.lienzoPadre = lienzoPadre;
        this.jugador = new Jugador(this);
        this.setSize(960, 480);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < ANCHO; i++) {
            for (int j = 0; j < ALTO; j++) {
                celdas[i][j].paintComponent(g);
            }
        }
    }

    private void initMundo() {
        for (int i = 0; i < ANCHO; i++) {
            for (int j = 0; j < ALTO; j++) {
                celdas[i][j] = new Celda(i + (i * TAM_CELDA), j + (j * TAM_CELDA), MUNDO);
            }
        }
    }

    private void insertarObstaculo(int x1, int x2, int y1, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                celdas[i][j].tipo = OBSTACULO;
            }
        }
    }
}
