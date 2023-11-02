package ItemTests;

import Item.DefensaX;
import Modificaciones.ModificacionDefensa;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefensaXTest {

    @Test
    public void testAplicarItem() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        ModificacionDefensa modificacion = mock(ModificacionDefensa.class);
        DefensaX defensaX = new DefensaX("Defensa X", 5, modificacion);
        //Act
        boolean realizo = defensaX.aplicarItem(cualidades);
        //Assert
        assert realizo;
    }
}
