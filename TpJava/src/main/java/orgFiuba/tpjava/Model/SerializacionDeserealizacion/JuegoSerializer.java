package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import orgFiuba.tpjava.Model.Juego;
import orgFiuba.tpjava.Model.Jugador;
import orgFiuba.tpjava.Model.Pokemones.Pokemon;

import java.io.IOException;

public class JuegoSerializer extends JsonSerializer<Juego> {

    public JuegoSerializer() {
        this(null);
    }

    public JuegoSerializer(Class<Juego> t) {
    }

    @Override
    public void serialize(Juego juego, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartArray(); // Comienza la lista de jugadores

        // Serializa cada jugador en el juego
        escribirJugador(jgen, juego.getJugador1());
        escribirJugador(jgen, juego.getJugador2());

        jgen.writeEndArray(); // Termina la lista de jugadores
        //jgen.writeNumberField("",);

        //jgen.writeObjectField("estados",pokemon.getCualidades().obtenerEstadosActuales());

        /*jgen.writeStringField("apellido", persona.getApellido());
        jgen.writeStringField("direccion_calle", persona.getDireccion().getCalle());
        jgen.writeStringField("direccion_numero", persona.getDireccion().getNumero());
        jgen.writeStringField("direccion_ciudad", persona.getDireccion().getCiudad());
        jgen.writeEndObject();*/
    }
    private void escribirJugador(JsonGenerator jgen, Jugador jugador) throws IOException {
        jgen.writeStartObject(); // Comienza un objeto para un jugador
        jgen.writeStringField("nombre", jugador.getNombre());
        jgen.writeBooleanField("ganador", jugador.esPerdedor());
        // Serializa otros campos de Jugador (items, pokemons, etc.) según sea necesario
        //jgen.writeObjectField("items", jugador.getItems());
        //jgen.writeObjectField("pokemons", jugador.getPokemons());
        jgen.writeEndObject(); // Termina el objeto para un jugador
    }
    private void escribirPokemon(JsonGenerator jgen, Pokemon pokemon)throws IOException{

    }


}
