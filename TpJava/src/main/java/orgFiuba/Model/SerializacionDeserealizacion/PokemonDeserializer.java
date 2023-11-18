package orgFiuba.Model.SerializacionDeserealizacion;


import orgFiuba.Model.Pokemones.Habilidad;
import orgFiuba.Model.Pokemones.Pokemon;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PokemonDeserializer extends StdDeserializer<Pokemon> {

    public PokemonDeserializer() {
        this(null);
    }

    public PokemonDeserializer(Class<Pokemon> t) {
        super(t);
    }

    @Override
    public Pokemon deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String nombre = node.get("nombre").asText();
        String historia = node.get("historia").asText();
        int nivel = node.get("nivel").asInt();
        String tipo = node.get("tipo").asText();
        double vida = node.get("vidaMaxima").asDouble();
        int velocidad = node.get("velocidad").asInt();
        int defensa = node.get("defensa").asInt();
        int ataque = node.get("ataque").asInt();

        String habilidadesJsonPath = "ruta/a/habilidades.json";

        Pokemon Pokemon = new Pokemon(nombre,nivel,tipo,historia,vida ,velocidad,defensa,ataque);

        /*try {
            File habilidadesFile = new File(habilidadesJsonPath);
            ObjectMapper objectMapper = new ObjectMapper();
            HabilidadDeserializer habilidadDeserializer = new HabilidadDeserializer();

            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addDeserializer(Habilidad.class, habilidadDeserializer);

            objectMapper.registerModule(simpleModule);

            // Lee el HashMap directamente
            Map<Integer, Habilidad> habilidadesMap = objectMapper.readValue(habilidadesFile, new TypeReference<Map<Integer, Habilidad>>() {});

            // Crea el objeto Pokemon con el HashMap de habilidades
            //Pokemon pokemon = new Pokemon(nombre, nivel, tipo, historia, vida, velocidad, defensa, ataque, habilidadesMap);

            //return pokemon;
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }*/
        return null;
    }
}