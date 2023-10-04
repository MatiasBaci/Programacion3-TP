package Opciones;

import org.fiuba.algoritmos3.Jugador;

public class Rendirse implements Opciones{

    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario) {
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");

       // jugador.setAtacante(false);

        //this.ganar(jugadorAdversario);
    }
}
