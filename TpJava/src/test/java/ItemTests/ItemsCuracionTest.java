package ItemTests;

import Item.ItemsCuracion;
import Item.Pocion;
import Pokemones.Cualidades;
import Modificaciones.ModificacionVida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemsCuracionTest {

    @Test
    public void testRealizarUsadoItemsDeCuracionConVidaMaximaNoModificaCantidad() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();

        ItemsCuracion item = new Pocion("Pocion", 10, modificacion);
        //Act
        boolean usado = item.realizarUsadoItemsDeCuracion(cualidades);
        //Assert
        assertFalse(usado);
        assertEquals(10, item.getCantidad());
    }

    @Test
    public void testRealizarUsadoItemsDeCuracionConVida0NoModificaCantidad() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();

        ItemsCuracion item = new Pocion("Pocion", 10, modificacion);
        //Act
        boolean usado = item.realizarUsadoItemsDeCuracion(cualidades);
        //Assert
        assertFalse(usado);
        assertEquals(10, item.getCantidad());
    }

    @Test
    public void testRealizarUsadoItemsDeCuracionConVidaNoMaximaNi0ModificaCantidad() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(50.0);
        when(cualidades.getVidaMaxima()).thenReturn(100.0);
        ModificacionVida modificacion = new ModificacionVida();

        ItemsCuracion item = new Pocion("Pocion", 10, modificacion);
        //Act
        boolean usado = item.realizarUsadoItemsDeCuracion(cualidades);
        //Assert
        assertTrue(usado);
        assertEquals(9, item.getCantidad());
    }
}
