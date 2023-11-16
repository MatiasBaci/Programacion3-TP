package SerializacionDeserealizacion;


import Pokemones.Pokemon;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

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

        return Pokemon;
    }
}