package SerializacionDeserealizacion;


import Estados.Estado;
import Pokemones.Habilidad;
import Pokemones.HabilidadAtaque;
import Pokemones.HabilidadEstadistica;
import Pokemones.HabilidadEstado;
import Tipo.Tipo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class HabilidadDeserializer extends StdDeserializer<Habilidad> {

    public HabilidadDeserializer() {
        this(null);
    }

    public HabilidadDeserializer(Class<Habilidad> t) {
        super(t);
    }

    @Override
    public Habilidad deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String nombre = node.get("nombre").asText();
        int  id = node.get("id").asInt();
        String tipoDeHabilidad = node.get("tipoDeHabilidad").asText();
        int cantidad= node.get("cantidad").asInt();

        switch (tipoDeHabilidad.toLowerCase()) {
            case "ataque":
                int poder= node.get("poder").asInt();
                String tipo= node.get("tipo").asText();
                return new HabilidadAtaque(nombre, Tipo.instanciarUnTipoDe(tipo),poder,cantidad);
            case "estado":
                String estado = node.get("estado").asText();
                return new HabilidadEstado(nombre,cantidad, Estado.instaciarUnEstadoDe(estado));
            case "estadistica":
                boolean propio = node.get("beneficio").asBoolean();
                String modificacion = node.get("modificacion").asText();
                int etapas = node.get("etapas").asInt();
                return null;//new HabilidadEstadistica(nombre,cantidad,propio,etapas,);
            case "clima":
                return null;
            default:
                throw new IllegalArgumentException("Tipo de habilidad no reconocido: " + tipoDeHabilidad);
        }

        //Habilidad Habilidad = new Habilidad();

        //return Habilidad;
    }
}