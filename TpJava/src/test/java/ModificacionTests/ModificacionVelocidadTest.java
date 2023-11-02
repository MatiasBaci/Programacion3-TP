package ModificacionTests;

import Modificaciones.ModificacionVelocidad;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionVelocidadTest {

    @Test
    public void testModificacionVelocidadModificaVelocidad() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        when(cualidades.getVelocidad()).thenReturn(10);
        ModificacionVelocidad modificacion = new ModificacionVelocidad();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarVelocidad(1);
    }

    @Test
    public void testModificacionVelocidadNoModificaVelocidadSiLaVidaEs0() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getVelocidad()).thenReturn(10);
        ModificacionVelocidad modificacion = new ModificacionVelocidad();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarVelocidad(1);
    }
}
