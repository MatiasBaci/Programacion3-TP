package ModificacionTests;

import Modificaciones.ModificacionDefensa;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionDefensaTest {

    @Test
    public void testModificacionDefensaModificaDefensa() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        when(cualidades.getDefensa()).thenReturn(10);
        ModificacionDefensa modificacion = new ModificacionDefensa();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarDefensa(1);
    }

    @Test
    public void testModificacionDefensaNoModificaDefensaSiLaVidaEs0() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getDefensa()).thenReturn(10);
        ModificacionDefensa modificacion = new ModificacionDefensa();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarDefensa(1);
    }
}
