package orgFiuba.Model.SerializacionDeserealizacion;


import orgFiuba.Model.Estados.Estado;
import orgFiuba.Model.Modificaciones.*;
import orgFiuba.Model.Pokemones.*;
import orgFiuba.Model.Tipos.Tipo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDeserializer extends StdDeserializer<List<HabilidadIdsCustom>> {

    public HabilidadDeserializer() {
        this(null);
    }

    public HabilidadDeserializer(Class<Habilidad> t) {
        super(t);
    }

    @Override
    public List<HabilidadIdsCustom>  deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        List<HabilidadIdsCustom> habilidadesMap = new ArrayList<>();

        for(JsonNode habilidadesNode: node){
            String nombre = habilidadesNode.get("nombre").asText();
            int  id = habilidadesNode.get("id").asInt();
            String tipoDeHabilidad = habilidadesNode.get("tipoDeHabilidad").asText();
            int cantidad= habilidadesNode.get("cantidad").asInt();
            Habilidad unaHabilidad = null;

            switch (tipoDeHabilidad.toLowerCase()) {
                case "ataque":
                    int poder= habilidadesNode.get("poder").asInt();
                    String tipo= habilidadesNode.get("tipo").asText();
                    unaHabilidad = new HabilidadAtaque(nombre, Tipo.instanciarUnTipoDe(tipo),poder,cantidad);
                    break;
                case "estado":
                    String estado = habilidadesNode.get("estado").asText();
                    unaHabilidad = new HabilidadEstado(nombre,cantidad, Estado.instaciarUnEstadoDe(estado));
                    break;
                case "estadistica":
                    boolean propio = habilidadesNode.get("beneficio").asBoolean();
                    //Modificacion modificacion = codec.treeToValue(habilidadesNode.get("tipoDeModificacion"), Modificacion.class);
                    String  tipoDeModificacion = habilidadesNode.get("tipoDeModificacion").asText();

                    // Usa el método para obtener la instancia de Modificacion
                    Modificacion modificacion = obtenerModificacion(tipoDeModificacion);
                    int etapas = habilidadesNode.get("etapas").asInt();
                    unaHabilidad = new HabilidadEstadistica(nombre,cantidad,propio,etapas,modificacion);
                    break;
                case "clima":
                    String clima = habilidadesNode.get("tipoDeClima").asText();
                    unaHabilidad = new HabilidadClima(nombre,clima,cantidad);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de habilidad no reconocido: " + tipoDeHabilidad);
            }
            habilidadesMap.add(new HabilidadIdsCustom(id,unaHabilidad));
        }

        return habilidadesMap;
    }
    private Modificacion obtenerModificacion(String tipo) {
        switch (tipo) {
            case "velocidad":
                return new ModificacionVelocidad();
            case "ataque":
                return new ModificacionAtaque();
            case "defensa":
                return new ModificacionDefensa();
            case "vida":
                return new ModificacionVida();
            default:
                throw new IllegalArgumentException("Tipo de modificación desconocido: " + tipo);
        }
    }
}