package org.fiuba.algoritmos3;
/* import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; */

public class Main {

public static void main(String[] args) {

        Pokemon charmander = new Pokemon("Charmander", 5, "Fuego", "historia de charmander", 100, 100, 100, 100);
        Pokemon squirtle = new Pokemon("Squirtle", 5, "Agua", "historia de squirtle", 100, 100, 100, 100);

        charmander.añadirHabilidad("Lanzallamas", Tipo.getTipo("Fuego"));
        squirtle.añadirHabilidad("Chorro de agua", Tipo.getTipo("Agua"));

        charmander.atacar(squirtle, charmander.seleccionarHabilidad("Lanzallamas"));
        squirtle.atacar(charmander, squirtle.seleccionarHabilidad("Chorro de agua"));
        // NO FUNCIONA LOL hay que solucionar el tema de la referencia a Tipo

        /* Juego juego = new Juego();
        juego.inicializarJuego();
        juego.DesarrollarJuego();
 */
    }


}
