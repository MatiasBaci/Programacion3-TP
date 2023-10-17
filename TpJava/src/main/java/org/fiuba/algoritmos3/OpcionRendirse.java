package org.fiuba.algoritmos3;

public class OpcionRendirse implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador) {
        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");

        jugador.setAtacante(false);
        jugador.perder();
    }
}
