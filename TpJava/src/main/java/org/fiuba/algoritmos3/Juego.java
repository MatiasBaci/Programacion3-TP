import java.util.ArrayList;
import java.util.List;

public class Juego {

    //Atributos:
    private Jugador jugador_1;
    private Jugador jugador_2;
    private Controlador controlador;

    //Metodos:

    public Juego(Datos datos){
        jugador_1.setPokemones(datos.getDatosPokemones());
    }

    public void inicializarMenu(){

        System.out.println("Bienvenido al juego.");
        //System.out.println("El jugador 1 tiene un"+ jugador_1.getPokemones().get(0).getNombre()+ "de nivel"+ jugador_1.getPokemones().get(0).getNivel());
    }

}
