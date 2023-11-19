package orgFiuba;

import orgFiuba.Model.Juego;
import orgFiuba.Model.Modificaciones.ModificacionVida;
import orgFiuba.Model.Pokemones.Habilidad;
import orgFiuba.Model.Pokemones.HabilidadEstadistica;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.Model.SerializacionDeserealizacion.HabilidadDeserializer;
import orgFiuba.Model.SerializacionDeserealizacion.HabilidadIdsCustom;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature; //--> para los tabs
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;
import orgFiuba.Model.SerializacionDeserealizacion.PokemonDeserializer;
import orgFiuba.Model.SerializacionDeserealizacion.PokemonIdsCustom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static orgFiuba.Constantes.RUTA_POKEMONS_JSON;

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

    String pokemonJsonPath = RUTA_POKEMONS_JSON; //--> Ruta Relativa
    try {
        File pokemonFile = new File(pokemonJsonPath);
        ObjectMapper objectMapperPokemon = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PokemonIdsCustom.class, new PokemonDeserializer()); ///-> PokemonIds
        objectMapperPokemon.registerModule(module);

        List<PokemonIdsCustom> listaPokemon = objectMapperPokemon.readValue(pokemonFile,new TypeReference<List<PokemonIdsCustom>>() {});
        System.out.println(listaPokemon);

    } catch (IOException e) {
        e.printStackTrace();
    }

    /*----------------------------------------------------------------------------------------------------------------------------
    String habilidadesJsonPath = "TpJava/outputJson/habilidades.json";
    try {
        File habilidadesFile = new File(habilidadesJsonPath);
        ObjectMapper objectMapper2 = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(List.class, new HabilidadDeserializer());
        objectMapper2.registerModule(module);

        List<HabilidadIdsCustom> habilidades = objectMapper2.readValue(habilidadesFile, new TypeReference<List<HabilidadIdsCustom>>() {});
        System.out.println(habilidades);

    } catch (IOException e) {
        e.printStackTrace();
        // Manejar la excepción adecuadamente
    }*/
 }
}
