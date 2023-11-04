package Opciones;

import org.fiuba.algoritmos3.Jugador;
import org.fiuba.algoritmos3.ServicioDeUserInput;
import view.GeneralView;

import java.util.Objects;
import java.util.Scanner;

import static org.fiuba.algoritmos3.Constantes.*;

public class OpcionAtacar implements Opciones{

    
    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeAtacarPokemon();

        String nombreHabilidad;

        nombreHabilidad = ServicioDeUserInput.input();

        if(!jugador.validarHabilidadPokemon(nombreHabilidad)) {
            System.out.println(ANSI_ROJO +"ERROR: LA HABILIDAD NO EXISTE.\n " + ANSI_RESET);

        }else{
            System.out.println(ANSI_VERDEOSCURO + "Desa realizar el ataque? Si - No." + ANSI_RESET);

            String decision = ServicioDeUserInput.input();
            if(Objects.equals(decision.toLowerCase(), "si")){
                jugador.atacarJugador(jugador.getAdversario(), nombreHabilidad);
                generalView.mostrarCasoAtques(jugador.getPokemonActual(), jugador.getAdversario(), nombreHabilidad);
            }else{
                System.out.println(ANSI_ROJO + "No se realizo el ataque." + ANSI_RESET);
            }
            generalView.mensajeVolverAlMenu();

            ServicioDeUserInput.input();
        }






    }
}
