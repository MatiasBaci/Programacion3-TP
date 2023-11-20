package orgFiuba.Model.SerializacionDeserealizacion;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orgFiuba.Model.Exceptions.HabilidadNoEncontradaException;
import orgFiuba.Model.Items.*;
import orgFiuba.Model.Modificaciones.Modificacion;
import orgFiuba.Model.Pokemones.Habilidad;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.Model.ServicioDeLecturasJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.spi.CurrencyNameProvider;

import static orgFiuba.Constantes.NO_CRITICO;
import static orgFiuba.Constantes.RUTA_HABILIDADES_JSON;

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
        int id = node.get("id").asInt();
        Modificacion modificacion = ServicioDeLecturasJson.obtenerModificacion(node.get("tipoDeModificacion").asText());

        Item unItem = this.creandoItemsSegunElNomnbre(nombre,0,modificacion);

        return new ItemsIdsCustom(id,unItem);
    }
    private Item creandoItemsSegunElNomnbre(String nombre,int cantidad,Modificacion unaModificacion){
        switch (nombre) {
            case "Hiper Pocion":
                return new HiperPocion(nombre, cantidad,unaModificacion);
            case "Pocion":
                return new Pocion(nombre, cantidad,unaModificacion);
            case "Mega Pocion":
                return new MegaPocion(nombre, cantidad,unaModificacion);
            case "Pocion MolestaAlumnos":
                return new PocionMolestaAlumnos(nombre,cantidad,unaModificacion);
            case "AtaqueX":
                return new AtaqueX(nombre,cantidad,unaModificacion);
            case "DefensaX":
                return new DefensaX(nombre,cantidad,unaModificacion);
            case "Revivir":
                return new Revivir(nombre,cantidad,unaModificacion);
            case "Cura Todo":
                return new PocionCuracionEstados(nombre,cantidad,unaModificacion);
            default:
                // Puedes lanzar una excepción si el nombre no coincide con ninguna clase conocida
                throw new IllegalArgumentException("Nombre de Item desconocido: " + nombre);
        }
    }
}