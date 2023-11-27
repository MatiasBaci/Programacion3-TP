package orgFiuba.tpjava.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import orgFiuba.tpjava.Model.Estados.*;
import orgFiuba.tpjava.Model.Items.*;
import orgFiuba.tpjava.Model.Modificaciones.*;
import orgFiuba.tpjava.Model.Pokemones.*;
import orgFiuba.tpjava.Model.SerializacionDeserealizacion.*;
import orgFiuba.tpjava.Model.Tipos.Tipo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static orgFiuba.tpjava.Constantes.*;

public class Datos {

    //Atributos:
    private final Map<String, Pokemon> mochilaJugador1;
    private final Map<String, Pokemon> mochilaJugador2;
    private final Map<String, Item> itemsJugador1;
    private final Map<String, Item> itemsJugador2;

    private List<Jugador> listaJugadores;

    //Metodos:

    public Datos() {

        this.mochilaJugador1 = new HashMap<>();
        this.mochilaJugador2 = new HashMap<>();
        this.itemsJugador1 = new HashMap<>();
        this.itemsJugador2 = new HashMap<>();
        this.listaJugadores = new ArrayList<>();

        this.listaJugadores = this.lecturaJugadoresJson();
        this.InicializarJugador(mochilaJugador1,itemsJugador1,0);
        this.InicializarJugador(mochilaJugador2,itemsJugador2,0);
    }

    public Map<String, Item> getItemsJugador1() {
        return this.itemsJugador1;
    }

    public Map<String, Item> getItemsJugador2() {
        return this.itemsJugador2;
    }

    public Map<String, Pokemon> getMochilaJugador1() {
        return this.mochilaJugador1;
    }

    public Map<String, Pokemon> getMochilaJugador2() {
        return this.mochilaJugador2;
    }


    private List<Jugador> lecturaJugadoresJson(){
        String pathPartida="TpJava/outputJson/partida.json";
        try {
            File partidaFile = new File(pathPartida);
            ObjectMapper objectMapperPokemon = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Jugador.class, new PartidaDeserializer()); ///-> PokemonIds
            objectMapperPokemon.registerModule(module);

            List<Jugador> listaDeJugadores = objectMapperPokemon.readValue(partidaFile,new TypeReference<List<Jugador>>() {});
            //System.out.println(listaDeJugadores);
            return listaDeJugadores;

        } catch (IOException e) {
            e.printStackTrace();
            //return null;
        }
        return null;
    }
    private void InicializarJugador(Map<String, Pokemon> mochila, Map<String, Item> item,int jugadorID){
        mochila = this.listaJugadores.get(jugadorID).getMisPokemones();
        item = this.listaJugadores.get(jugadorID).getItems();
    }

}
