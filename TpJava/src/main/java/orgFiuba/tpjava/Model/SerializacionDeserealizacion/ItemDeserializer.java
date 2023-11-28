package orgFiuba.tpjava.Model.SerializacionDeserealizacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orgFiuba.tpjava.Model.Exceptions.HabilidadNoEncontradaException;
import orgFiuba.tpjava.Model.Items.*;
import orgFiuba.tpjava.Model.Modificaciones.Modificacion;
import orgFiuba.tpjava.Model.Pokemones.Habilidad;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;
import orgFiuba.tpjava.Model.ServicioDeLecturasJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.spi.CurrencyNameProvider;

import static orgFiuba.tpjava.Constantes.NO_CRITICO;
import static orgFiuba.tpjava.Constantes.RUTA_HABILIDADES_JSON;

public class ItemDeserializer extends StdDeserializer<ItemsIdsCustom> {

    public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<Item> t) {
        super(t);
    }

    @Override
    public ItemsIdsCustom deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String nombre = node.get("nombre").asText();
        String descripcion = node.get("descripcion").asText();
        int id = node.get("id").asInt();
        Modificacion modificacion = ServicioDeLecturasJson.obtenerModificacion(node.get("tipoDeModificacion").asText());

        Item unItem = this.creandoItemsSegunElNomnbre(nombre,0,modificacion,descripcion);

        return new ItemsIdsCustom(id,unItem);
    }
    private Item creandoItemsSegunElNomnbre(String nombre,int cantidad,Modificacion unaModificacion,String descripcion){
        // Puedes lanzar una excepción si el nombre no coincide con ninguna clase conocida
        return switch (nombre) {
            case "Hiper Pocion" -> new HiperPocion(nombre, cantidad, unaModificacion, descripcion);
            case "Pocion" -> new Pocion(nombre, cantidad, unaModificacion, descripcion);
            case "Mega Pocion" -> new MegaPocion(nombre, cantidad, unaModificacion, descripcion);
            case "Pocion MolestaAlumnos" -> new PocionMolestaAlumnos(nombre, cantidad, unaModificacion, descripcion);
            case "AtaqueX" -> new AtaqueX(nombre, cantidad, unaModificacion, descripcion);
            case "DefensaX" -> new DefensaX(nombre, cantidad, unaModificacion, descripcion);
            case "Revivir" -> new Revivir(nombre, cantidad, unaModificacion, descripcion);
            case "Cura Todo" -> new PocionCuracionEstados(nombre, cantidad, unaModificacion, descripcion);
            default -> throw new IllegalArgumentException("Nombre de Item desconocido: " + nombre);
        };
    }
}