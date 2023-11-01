package org.fiuba.algoritmos3;

import view.GeneralView;
import view.JugadorView;

import java.util.Objects;
import java.util.Scanner;

import static org.fiuba.algoritmos3.Constantes.*;

public class OpcionAtacar implements Opciones{

    @Override
    public void aplicarOpcion(Jugador jugador, GeneralView generalView){

        generalView.mostrarMensajeAtacarPokemon();
        Scanner scanner = new Scanner(System.in);
        String nombreHabilidad;
        nombreHabilidad = scanner.next();

        if(!jugador.validarHabilidadPokemon(nombreHabilidad)) {
            JugadorView.mostrarHabilidadNoExiste();
            return;
        }else{
            System.out.println(ANSI_VERDEOSCURO + "Desa realizar el ataque? Si - No." + ANSI_RESET);
            String decision = scanner.next();
            if(Objects.equals(decision.toLowerCase(), "si")){
                jugador.atacarJugador(jugador.getAdversario(), nombreHabilidad);
                generalView.mostrarCasoAtques(jugador.getPokemonActual(), jugador.getAdversario(), nombreHabilidad);
            }else{
                System.out.println(ANSI_ROJO + "No se realizo el ataque." + ANSI_RESET);
            }
            generalView.mensajeVolverAlMenu();
            scanner.next();
        }






    }
}