package TareaIA;

import java.util.TimerTask;

public class Auto extends TimerTask implements Constantes {

    public Laberinto laberinto;
    public Celda auto;
    public int x;
    public int y;
   
    public Auto(Laberinto laberinto,int x, int y) {
        this.laberinto = laberinto;
        this.x = x;
        this.y = y;
        auto = new Celda(x, y, AUTO);
        laberinto.celdas[auto.X][auto.Y].tipo = AUTO;
    }

    public void moverAuto() {
        if (auto.X > 0) {
            laberinto.celdas[auto.X][auto.Y].tipo = MUNDO;
            auto.X = auto.X - 1;
            laberinto.celdas[auto.X][auto.Y].tipo = AUTO;
        }else {
            laberinto.celdas[auto.X][auto.Y].tipo = MUNDO;
            auto.X = x;
            auto.Y = y;
            laberinto.celdas[auto.X][auto.Y].tipo = AUTO;
        }
    }
@Override
    public void run() {
        moverAuto();
        laberinto.lienzoPadre.repaint();
    }
}