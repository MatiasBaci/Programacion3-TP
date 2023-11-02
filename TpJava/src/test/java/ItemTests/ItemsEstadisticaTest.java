package ItemTests;

import Item.AtaqueX;
import Item.ItemsEstadistica;
import Pokemones.Cualidades;
import Modificaciones.Modificacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemsEstadisticaTest {

    @Test
    public void testRealizarUsadoItemsDeEstadisitcasConVidaDistintaDe0() {
        // Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(100.0);
        Modificacion modificacion = mock(Modificacion.class);
        ItemsEstadistica itemsEstadistica = new AtaqueX("Ataque X", 5, modificacion);
        // Act
        boolean resultado = itemsEstadistica.realizarUsadoItemsDeEstadisitcas(cualidades);
        // Assert
        assertTrue(resultado);
        assertEquals(4, itemsEstadistica.getCantidad());
    }

    @Test
    public void testRealizarUsadoItemsDeEstadisitcasConVidaIgualA0() {
        // Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        Modificacion modificacion = mock(Modificacion.class);
        ItemsEstadistica itemsEstadistica = new AtaqueX("Ataque X", 5, modificacion);
        // Act
        boolean resultado = itemsEstadistica.realizarUsadoItemsDeEstadisitcas(cualidades);
        // Assert
        assertEquals(false, resultado);
        assertEquals(5, itemsEstadistica.getCantidad());
    }
}
