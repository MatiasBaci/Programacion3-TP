package orgFiuba.tpjava;

import orgFiuba.tpjava.Model.Items.HiperPocion;
import orgFiuba.tpjava.Model.Items.Item;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Modificaciones.ModificacionVida;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.HabilidadEstadistica;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.SerializacionDeserealizacion.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature; //--> para los tabs
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static orgFiuba.tpjava.Constantes.RUTA_POKEMONS_JSON;

public class Main {

public static void main(String[] args) throws IOException {
    //Juego juego = new Juego();
    //juego.DesarrollarJuego();
    //-----------------------------------------------------------------------------------------------------------
   // String path = "TpJava/outputJson/pokemon.json"; //--> Ruta Relativa
   // Pokemon unPokemon = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
  //          153, 120, 105, 129);
  //  Habilidad respiro = new HabilidadEstadistica("Respiro", 5, true, (int)(unPokemon.obtenerVidaMaxima()/2), new ModificacionVida());
   // unPokemon.aniadirHabilidad(respiro);

  //  ObjectMapper objectMapper = new ObjectMapper();
  //  objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
  //  objectMapper.writeValue(new File(path),unPokemon); //-----------> Serializacion
    //------------------------------------------------------------------------------------------------------------


    /*String pathItems = "TpJava/outputJson/itemPrueba.json";
    Item unItem = new HiperPocion("Hiper Pocion",5,new ModificacionVida());
    ObjectMapper objectMapperItems = new ObjectMapper();
    objectMapperItems.enable(SerializationFeature.INDENT_OUTPUT);
    objectMapperItems.writeValue(new File(pathItems),unItem); //-----------> Serializacion*/

    String pathPartida="TpJava/outputJson/partida.json";
    try {
        File partidaFile = new File(pathPartida);
        ObjectMapper objectMapperPokemon = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Jugador.class, new PartidaDeserializer()); ///-> PokemonIds
        objectMapperPokemon.registerModule(module);

        List<Jugador> listaDeJugadores = objectMapperPokemon.readValue(partidaFile,new TypeReference<List<Jugador>>() {});
        System.out.println(listaDeJugadores);

        //Map<Integer, Pokemon> pokemonID = listaPokemon.stream()
                //.collect(Collectors.toMap(PokemonIdsCustom::getId, PokemonIdsCustom::getUnaHabilida));
        //return pokemonID;

    } catch (IOException e) {
        e.printStackTrace();
        //return null;
    }
 }
}