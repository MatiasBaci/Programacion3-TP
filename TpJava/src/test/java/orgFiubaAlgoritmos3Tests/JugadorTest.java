package orgFiubaAlgoritmos3Tests;

import Pokemones.Pokemon;
import org.fiuba.algoritmos3.Jugador;
import Item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

public class JugadorTest {

    @Test
    public void testPerdioDevuelveFalseSiTodosLosPokemonEstanConscientesYNoSeRindio() {
        //Arrange
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        Pokemon charmander = mock(Pokemon.class);
        when(pikachu.estaConsciente()).thenReturn(true);
        when(charmander.estaConsciente()).thenReturn(true);
        misPokemones.put("Pikachu", pikachu);
        misPokemones.put("Charmander", charmander);

        Jugador jugador = new Jugador("Ash", misPokemones, null);

        //Act
        //Assert
        assertFalse(jugador.perdio());
    }

    @Test
    public void testPerdioDevuelveFalseSiAlgunPokemonEstaInconscienteYNoSeRindio() {
        //Arrange
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        Pokemon charmander = mock(Pokemon.class);
        when(pikachu.estaConsciente()).thenReturn(true);
        when(charmander.estaConsciente()).thenReturn(false);
        misPokemones.put("Pikachu", pikachu);
        misPokemones.put("Charmander", charmander);

        Jugador jugador = new Jugador("Ash", misPokemones, null);

        //Act
        //Assert
        assertFalse(jugador.perdio());
    }

    @Test
    public void testPerder() {
        //Arrange
        Pokemon pikachu = mock(Pokemon.class);
        when(pikachu.estaConsciente()).thenReturn(true);
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Jugador jugador = new Jugador("Ash", misPokemones, null);

        //Act
        jugador.perder();
        //Assert
        assertTrue(jugador.perdio());
    }

    @Test
    public void testElegirItemInexistente() {
        //Arrange
        Jugador jugador = new Jugador("Ash", null, null);
        //Act
        //Assert
        assertThrows(NullPointerException.class, () -> jugador.elegirItem("Pocion"));
    }

    @Test
    public void testElegirItemExistente() {
        //Arrange
        Map<String, Item> items = new HashMap<>();
        Item pocion = mock(Item.class);
        when(pocion.getNombre()).thenReturn("Pocion");
        Item superPocion = mock(Item.class);
        when(superPocion.getNombre()).thenReturn("Super Pocion");
        items.put("Pocion", pocion);
        items.put("Super Pocion", superPocion);
        Jugador jugador = new Jugador("Ash", null, items);
        //Act
        //Assert
        assertEquals("Pocion", jugador.elegirItem("Pocion").getNombre());
    }

    @Test
    public void testElegirPokemonInexistenteDevuelveFalse() {
        //Arrange
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        when(pikachu.getNombre()).thenReturn("Pikachu");
        misPokemones.put("Pikachu", pikachu);
        Jugador jugador = new Jugador("Ash", misPokemones, null);
        //Act
        //Assert
        assertFalse(jugador.elegirPokemon("Charmander"));
    }

    @Test
    public void testElegirPokemonInconscienteDevuelveFalse() {
        //Arrange
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        when(pikachu.getNombre()).thenReturn("Pikachu");
        when(pikachu.estaConsciente()).thenReturn(false);
        misPokemones.put("Pikachu", pikachu);
        Jugador jugador = new Jugador("Ash", misPokemones, null);
        //Act
        //Assert
        assertFalse(jugador.elegirPokemon("Pikachu"));
    }

    @Test
    public void testElegirPokemonConscienteDevuelveTrue() {
        //Arrange
        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pikachu = mock(Pokemon.class);
        when(pikachu.getNombre()).thenReturn("Pikachu");
        when(pikachu.estaConsciente()).thenReturn(true);
        misPokemones.put("Pikachu", pikachu);
        Jugador jugador = new Jugador("Ash", misPokemones, null);
        //Act
        //Assert
        assertTrue(jugador.elegirPokemon("Pikachu"));
    }

/*    @Test //TODO testear como test de integracion
    public void testUsarItemCuandoTodaviaQueda() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);

        Map<String, Pokemon> misPokemones = new HashMap<>();
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCualidades()).thenReturn(cualidades);
        misPokemones.put("Pikachu", pokemon);

        Map<String, Item> items = new HashMap<>();
        Item pocion = mock(Item.class);
        when(pocion.realizarCasosDeApliacion(cualidades)).thenReturn(true);
        items.put("Pocion", pocion);

        Jugador jugador = new Jugador("Ash", misPokemones, items);
        //Act
        //Assert
        assertTrue(jugador.usarItem("Pocion", pocion));
    }*/



}
