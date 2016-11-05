package TareaIA;

import java.awt.event.KeyEvent;

public class Jugador implements Constantes {

    public Laberinto laberinto;
    public Celda jugador;
    
    public Jugador(Laberinto laberinto){
        this.laberinto = laberinto;
        jugador = new Celda(1, 1, JUGADOR);
        laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
    }
    
    
    public void moverCeldaArriba() {
        if (jugador.Y > 0 && laberinto.celdas[jugador.X][jugador.Y - 1].tipo != OBSTACULO
                && laberinto.celdas[jugador.X][jugador.Y - 1].tipo != AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.Y = jugador.Y - 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void moverCeldaAbajo() {
        if (jugador.Y < ALTO - 1 && laberinto.celdas[jugador.X][jugador.Y + 1].tipo != OBSTACULO
                && laberinto.celdas[jugador.X][jugador.Y + 1].tipo != AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.Y = jugador.Y + 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void moverCeldaIzquierda() {
        if (jugador.X > 0 && laberinto.celdas[jugador.X - 1][jugador.Y].tipo != OBSTACULO
                && laberinto.celdas[jugador.X - 1][jugador.Y].tipo != AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.X = jugador.X - 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void moverCeldaDerecha() {
        if (jugador.X < ANCHO - 1 && laberinto.celdas[jugador.X + 1][jugador.Y].tipo != OBSTACULO
                && laberinto.celdas[jugador.X + 1][jugador.Y].tipo != AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.X = jugador.X + 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void esquivarCeldaArriba() {
        if (jugador.Y > 0 && laberinto.celdas[jugador.X][jugador.Y - 1].tipo == AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void esquivarCeldaAbajo() {
        if (jugador.Y < ALTO - 1 && laberinto.celdas[jugador.X][jugador.Y + 1].tipo == AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void esquivarCeldaIzquierda() {
        if (jugador.X > 0 && laberinto.celdas[jugador.X - 1][jugador.Y].tipo == AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.Y = jugador.Y - 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }

    public void esquivarCeldaDerecha() {
        if (jugador.X < ANCHO - 1 && laberinto.celdas[jugador.X + 1][jugador.Y].tipo == AUTO) {
            laberinto.celdas[jugador.X][jugador.Y].tipo = MUNDO;
            jugador.Y = jugador.Y + 1;
            laberinto.celdas[jugador.X][jugador.Y].tipo = JUGADOR;
        }
    }
    
     void moverCelda(KeyEvent evento) {
        switch (evento.getKeyCode()) {
            case KeyEvent.VK_UP:
                moverCeldaArriba();
                esquivarCeldaArriba();
                break;
            case KeyEvent.VK_DOWN:
                moverCeldaAbajo();
                esquivarCeldaAbajo();
                break;
            case KeyEvent.VK_LEFT:
               moverCeldaIzquierda();
               esquivarCeldaIzquierda();
                break;
            case KeyEvent.VK_RIGHT:
                moverCeldaDerecha();
                esquivarCeldaDerecha();
                break;
        }
    }
}
