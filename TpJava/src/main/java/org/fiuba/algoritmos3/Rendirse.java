package org.fiuba.algoritmos3;

public class Rendirse implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, Jugador jugadorAdversario) {
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");

        jugador.setAtacante(false);
        jugador.perder();
    }
}
