package org.fiuba.algoritmos3;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

public class Datos {

    //Atributos:
    private Map<String, Pokemon> mochilaJugador1;
    private Map<String, Pokemon> mochilaJugador2;
    private Map<String, Item> itemsJugador1;
    private Map<String, Item> itemsJugador2;

    //Metodos:

    public Datos() {

        mochilaJugador1 = new HashMap<>();
        mochilaJugador2 = new HashMap<>();
        itemsJugador1 = new HashMap<>();
        itemsJugador2 = new HashMap<>();

        InicialzarPokemonesJugador1();
        InicialzarPokemonesJugador2();
    }

    private void InicialzarPokemonesJugador1(){

        Pokemon pokemon1 = new Pokemon("Squirtle", 5, "Agua", "Es un pokemon de Agua", 44, 43, 65, 50);
        Pokemon pokemon2 = new Pokemon("Charmander", 100, "Fuego", "Es un pokemon de Fuego", 39, 65, 50, 60);
        Pokemon pokemon3 = new Pokemon("Pikachu", 5, "Agua", "Es un pokemon de Agua", 100, 15, 20, 20);
        Pokemon pokemon4 = new Pokemon("Charizard", 5, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);
        Pokemon pokemon5 = new Pokemon("Vaporeon", 5, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);
        Pokemon pokemon6 = new Pokemon("Charmander_1", 10, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);

        Habilidad chorroDeAgua = new HabilidadAtaque("ChorroDeAgua",Tipo.getTipo("Agua"),40,25);
        Habilidad Lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.getTipo("Fuego"),90,15);

        Habilidad sanacion = new HabilidadEstadistica("Sanacion", 10,true, 2, new ModificacionVida());
        Habilidad dormir = new HabilidadEstado("Dormir", 4, new EstadoDormido("Dormido"));

        pokemon1.añadirHabilidad(chorroDeAgua);
        pokemon2.añadirHabilidad(Lanzallamas);
        pokemon2.añadirHabilidad(chorroDeAgua);
        pokemon1.añadirHabilidad(sanacion);
        pokemon1.añadirHabilidad(dormir);

        Item pocion = new Pocion("Pocion", 4, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 3, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 1, new ModificacionVida());
        Item pocionDefensa = new PocionDefensa("Pocion de Defensa", 2, new ModificacionDefensa());
        Item pocionAtaque = new PocionAtaque("Pocion de Ataque", 1, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionEstadoInhabilitado());
        Item curarTodo = new PocionCuracionEstados("Curar todo",1);
        mochilaJugador1.put(pokemon1.getNombre(), pokemon1);
        mochilaJugador1.put(pokemon2.getNombre(), pokemon2);
        mochilaJugador1.put(pokemon3.getNombre(), pokemon3);
        mochilaJugador1.put(pokemon4.getNombre(), pokemon4);
        mochilaJugador1.put(pokemon5.getNombre(), pokemon5);
        mochilaJugador1.put(pokemon6.getNombre(), pokemon6);

        itemsJugador1.put(pocion.getNombre(), pocion);
        itemsJugador1.put(megaPocion.getNombre(), megaPocion);
        itemsJugador1.put(hiperPocion.getNombre(), hiperPocion);
        itemsJugador1.put(revivir.getNombre(), revivir);
        itemsJugador1.put(pocionDefensa.getNombre(), pocionDefensa);
        itemsJugador1.put(pocionAtaque.getNombre(), pocionAtaque);
        itemsJugador1.put(curarTodo.getNombre(), curarTodo);

    }

    private void InicialzarPokemonesJugador2(){

        Pokemon pokemon1 = new Pokemon("Squirtle", 100, "Agua", "Es un pokemon de Agua", 44, 43, 65, 50);
        Pokemon pokemon2 = new Pokemon("Charmander", 5, "Fuego", "Es un pokemon de Fuego", 39, 65, 50, 60);
        Pokemon pokemon3 = new Pokemon("Pikachu", 5, "Agua", "Es un pokemon de Agua", 100, 15, 20, 20);
        Pokemon pokemon4 = new Pokemon("Charizard", 5, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);
        Pokemon pokemon5 = new Pokemon("Vaporeon", 5, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);
        Pokemon pokemon6 = new Pokemon("Charmander_1", 10, "Fuego", "Es un pokemon de Fuego", 100, 20, 25, 25);

        Habilidad chorroDeAgua = new HabilidadAtaque("ChorroDeAgua",Tipo.getTipo("Agua"),40,25);
        Habilidad Lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.getTipo("Fuego"),90,15);
        Habilidad sanacion = new HabilidadEstadistica("Sanacion", 10,true, 2, new ModificacionVida());

        Habilidad dormir = new HabilidadEstado("Dormir", 4, new EstadoDormido("Dormido"));

        pokemon1.añadirHabilidad(chorroDeAgua);
        pokemon2.añadirHabilidad(Lanzallamas);
        pokemon2.añadirHabilidad(chorroDeAgua);
        pokemon1.añadirHabilidad(sanacion);
        pokemon1.añadirHabilidad(dormir);

        Item pocion = new Pocion("Pocion", 1, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 2, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 4, new ModificacionVida());
        Item pocionDefensa = new PocionDefensa("Pocion de Defensa", 3, new ModificacionDefensa());
        Item pocionAtaque = new PocionAtaque("Pocion de Ataque", 2, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionVida());

        mochilaJugador2.put(pokemon1.getNombre(), pokemon1);
        mochilaJugador2.put(pokemon2.getNombre(), pokemon2);
        mochilaJugador2.put(pokemon3.getNombre(), pokemon3);
        mochilaJugador2.put(pokemon4.getNombre(), pokemon4);
        mochilaJugador2.put(pokemon5.getNombre(), pokemon5);
        mochilaJugador2.put(pokemon6.getNombre(), pokemon6);

        itemsJugador2.put(pocion.getNombre(), pocion);
        itemsJugador2.put(megaPocion.getNombre(), megaPocion);
        itemsJugador2.put(hiperPocion.getNombre(), hiperPocion);
        itemsJugador2.put(revivir.getNombre(), revivir);
        itemsJugador2.put(pocionDefensa.getNombre(), pocionDefensa);
        itemsJugador2.put(pocionAtaque.getNombre(), pocionAtaque);
    }

    public Map<String, Item> getItemsJugador1() {
        return itemsJugador1;
    }

    public Map<String, Item> getItemsJugador2() {
        return itemsJugador2;
    }

    public Map<String, Pokemon> getMochilaJugador1() {
        return mochilaJugador1;
    }

    public Map<String, Pokemon> getMochilaJugador2() {
        return mochilaJugador2;
    }
}
