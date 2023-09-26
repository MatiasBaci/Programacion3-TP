package org.fiuba.algoritmos3;
/* import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; */

public class Main {

public static void main(String[] args) {

        Pokemon charmander = new Pokemon("Charmander", 15, "Fuego", "historia de charmander", 100, 100, 100, 100);
        Pokemon squirtle = new Pokemon("Squirtle", 5, "Agua", "historia de squirtle", 100, 100, 100, 100);


        Habilidad chorroDeAgua = new HabilidadAtaque("chorrodeAgua",Tipo.getTipo("Agua"),15,10);
        Habilidad Lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.getTipo("Fuego"),15,10);

        Habilidad rugido = new HabilidadEstadistica("Rugido",20,false,-2,new ModificacionAtaque());
        Habilidad dobleEquipo = new HabilidadEstadistica("DobleEquipo",20,true,4,new ModificacionVelocidad());


        charmander.añadirHabilidad(Lanzallamas); // HABILIDAD ATAQUE
        charmander.añadirHabilidad(rugido); //HABILIDAD ESTADISTICA

        squirtle.añadirHabilidad(chorroDeAgua); //HABILIDAD ATAQUE
        squirtle.añadirHabilidad(dobleEquipo); //HABILIDAD ESTADISTICA


        //charmander.atacar(squirtle, "Lanzallamas");
        //squirtle.atacar(charmander, "chorrodeAgua");

        charmander.atacar(squirtle,"Rugido");
        squirtle.atacar(charmander,"DobleEquipo");


        //Juego juego = new Juego();
        //juego.inicializarJuego();
       // juego.DesarrollarJuego();
    }


}
