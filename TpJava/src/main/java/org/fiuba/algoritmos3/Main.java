package org.fiuba.algoritmos3;

import Modificaciones.ModificacionVida;
import Pokemones.Habilidad;
import Pokemones.HabilidadEstadistica;
import Pokemones.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature; //--> para los tabs

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

public static void main(String[] args) throws IOException {
    //Juego juego = new Juego();
    //juego.DesarrollarJuego();
    //-----------------------------------------------------------------------------------------------------------
    String path = "TpJava/outputJson/pokemon.json"; //--> Ruta Relativa
    Pokemon unPokemon = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
            153, 120, 105, 129);
    Habilidad respiro = new HabilidadEstadistica("Respiro", 5, true, (int)(unPokemon.obtenerVidaMaxima()/2), new ModificacionVida());
    unPokemon.aniadirHabilidad(respiro);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    objectMapper.writeValue(new File(path),unPokemon); //-----------> Serializacion
    //------------------------------------------------------------------------------------------------------------

    /*String path2 = "TpJava/outputJson/pokemonPrueba.json"; //--> Ruta Relativa
    ObjectMapper objectMapper2 = new ObjectMapper();

    try {
        List<Pokemon> pokemones = objectMapper2.readValue(new File(path2), objectMapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));

        // Ahora, 'pokemones' es una lista de objetos Pokemon
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.getCualidades().getVidaMaxima());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }*/
    }
}
