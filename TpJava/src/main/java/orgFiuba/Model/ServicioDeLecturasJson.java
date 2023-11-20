package orgFiuba.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import orgFiuba.Model.Items.Item;
import orgFiuba.Model.Modificaciones.*;
import orgFiuba.Model.Pokemones.Habilidad;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.Model.SerializacionDeserealizacion.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static orgFiuba.Constantes.RUTA_POKEMONS_JSON;

public class ServicioDeLecturasJson {

    static public Map<Integer, Habilidad> lecturaHabilidadesJson(String habilidadesPath){
        try {
            File habilidadesFile = new File(habilidadesPath);
            ObjectMapper objectMapper2 = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(List.class, new HabilidadDeserializer());
            objectMapper2.registerModule(module);

            List<HabilidadIdsCustom> habilidades = objectMapper2.readValue(habilidadesFile, new TypeReference<List<HabilidadIdsCustom>>() {});
            System.out.println(habilidades);
            Map<Integer, Habilidad> habilidadesID = habilidades.stream()
                    .collect(Collectors.toMap(HabilidadIdsCustom::getId, HabilidadIdsCustom::getUnaHabilida)); // ---> Lo tranformo en Hash para no usar Fors
            return habilidadesID;

        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
            return null;
        }
    }

    public static Map<Integer, Pokemon> lecturaPokemonJson(String pokemonsPath){
        try {
            File pokemonFile = new File(pokemonsPath);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(PokemonIdsCustom.class, new PokemonDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            List<PokemonIdsCustom> listaPokemon = objectMapperPokemon.readValue(pokemonFile,new TypeReference<List<PokemonIdsCustom>>() {});
            System.out.println(listaPokemon);

            Map<Integer, Pokemon> pokemonID = listaPokemon.stream()
                    .collect(Collectors.toMap(PokemonIdsCustom::getId, PokemonIdsCustom::getUnaHabilida));
            return pokemonID;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Map<Integer, Item> lecturaItemsJson(String itemsPath){
        try {
            File itemFile = new File(itemsPath);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(ItemsIdsCustom.class, new ItemDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            List<ItemsIdsCustom> listaItems = objectMapperPokemon.readValue(itemFile,new TypeReference<List<ItemsIdsCustom>>() {});
            System.out.println(listaItems);

            Map<Integer, Item> itemID = listaItems.stream()
            .collect(Collectors.toMap(ItemsIdsCustom::getId, ItemsIdsCustom::getUnItem));
            return itemID;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Modificacion obtenerModificacion(String tipo) {
        switch (tipo) {
            case "velocidad":
                return new ModificacionVelocidad();
            case "ataque":
                return new ModificacionAtaque();
            case "defensa":
                return new ModificacionDefensa();
            case "vida":
                return new ModificacionVida();
            case "estado":
                return new ModificacionEstado();
            default:
                throw new IllegalArgumentException("Tipo de modificación desconocido: " + tipo);
        }
    }
}
