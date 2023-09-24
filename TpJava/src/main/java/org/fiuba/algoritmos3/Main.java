package org.fiuba.algoritmos3;
/* import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; */

public class Main {

public static void main(String[] args) {

        Pokemon charmander = new Pokemon("Charmander", 15, "Fuego", "historia de charmander", 100.0, 100, 100, 100);
        Pokemon squirtle = new Pokemon("Squirtle", 5, "Agua", "historia de squirtle", 100.0, 100, 100, 100);


        Habilidad chorroDeAgua = new HabilidadAtaque("chorrodeAgua",Tipo.getTipo("Agua"),15,10);
        Habilidad Lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.getTipo("Fuego"),15,10);


        charmander.añadirHabilidad(Lanzallamas);
        squirtle.añadirHabilidad(chorroDeAgua);

        charmander.atacar(squirtle, "Lanzallamas");
        squirtle.atacar(charmander, "chorrodeAgua");


        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.DesarrollarJuego();
    }


}
