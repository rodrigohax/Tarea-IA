package TareaIA;

import TareaIA.*;
import java.awt.Point;
import java.util.TimerTask;

public class Peaton extends TimerTask implements Constantes {

    public Laberinto laberinto;
    public Celda peaton;
    public Point p1, p2, p3, p4;

    public Peaton(Laberinto laberinto, Point xp, Point yp) {
        p1 = new Point(xp.x, xp.y);
        p2 = new Point(yp.x, xp.y);
        p3 = new Point(yp.x, yp.y);
        p4 = new Point(xp.x, yp.y);
        this.laberinto = laberinto;
        peaton = new Celda(p1.x, p1.y, PEATON);
        laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
    }

    public void moverPeaton() {
        if (peaton.X == p2.x && peaton.Y < p3.y && peaton.Y >= p2.y) {
            moverCeldaAbajo();
            esquivarCeldaAbajo();
        } else if (peaton.X >= p1.x && peaton.Y == p1.y && peaton.X < p2.x) {
            moverCeldaDerecha();
            esquivarCeldaDerecha();
        } else if (peaton.X <= p3.x && peaton.Y == p3.y && peaton.X > p4.x) {
            moverCeldaIzquierda();
            esquivarCeldaIzquierda();
        } else if (peaton.X == p4.x && peaton.Y <= p4.y && peaton.Y >= p1.y) {
            moverCeldaArriba();
            esquivarCeldaArriba();
        }
    }

    public void moverCeldaArriba() {
        if (peaton.Y > 0 && laberinto.celdas[peaton.X][peaton.Y - 1].tipo != OBSTACULO
                && laberinto.celdas[peaton.X][peaton.Y - 1].tipo != AUTO
                && laberinto.celdas[peaton.X][peaton.Y - 1].tipo != JUGADOR) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.Y = peaton.Y - 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void moverCeldaAbajo() {
        if (peaton.Y < ALTO - 1 && laberinto.celdas[peaton.X][peaton.Y + 1].tipo != OBSTACULO
                && laberinto.celdas[peaton.X][peaton.Y + 1].tipo != AUTO
                 && laberinto.celdas[peaton.X][peaton.Y + 1].tipo != JUGADOR) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.Y = peaton.Y + 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void moverCeldaIzquierda() {
        if (peaton.X > 0 && laberinto.celdas[peaton.X - 1][peaton.Y].tipo != OBSTACULO
                && laberinto.celdas[peaton.X - 1][peaton.Y].tipo != AUTO
                && laberinto.celdas[peaton.X - 1][peaton.Y].tipo != JUGADOR) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.X = peaton.X - 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void moverCeldaDerecha() {
        if (peaton.X < ANCHO - 1 && laberinto.celdas[peaton.X + 1][peaton.Y].tipo != OBSTACULO
                && laberinto.celdas[peaton.X + 1][peaton.Y].tipo != AUTO
                && laberinto.celdas[peaton.X + 1][peaton.Y].tipo != JUGADOR) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.X = peaton.X + 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void esquivarCeldaArriba() {
        if (peaton.Y > 0 && laberinto.celdas[peaton.X][peaton.Y - 1].tipo == AUTO) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void esquivarCeldaAbajo() {
        if (peaton.Y < ALTO - 1 && laberinto.celdas[peaton.X][peaton.Y + 1].tipo == AUTO) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void esquivarCeldaIzquierda() {
        if (peaton.X > 0 && laberinto.celdas[peaton.X - 1][peaton.Y].tipo == AUTO) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.Y = peaton.Y - 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    public void esquivarCeldaDerecha() {
        if (peaton.X < ANCHO - 1 && laberinto.celdas[peaton.X + 1][peaton.Y].tipo == AUTO) {
            laberinto.celdas[peaton.X][peaton.Y].tipo = MUNDO;
            peaton.Y = peaton.Y + 1;
            laberinto.celdas[peaton.X][peaton.Y].tipo = PEATON;
        }
    }

    @Override
    public void run() {
        moverPeaton();
        laberinto.lienzoPadre.repaint();
    }
}
