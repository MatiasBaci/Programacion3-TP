package ModificacionTests;

import Modificaciones.ModificacionAtaque;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ModificacionAtaqueTest {

    @Test
    public void testModificacionAtaqueModificaAtaque() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(10.0);
        when(cualidades.getAtaque()).thenReturn(10);
        ModificacionAtaque modificacion = new ModificacionAtaque();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades).modificarAtaque(1);
    }

    @Test
    public void testModificacionAtaqueNoModificaAtaqueSiLaVidaEs0() {
        //Arrange
        Cualidades cualidades = mock(Cualidades.class);
        when(cualidades.getVida()).thenReturn(0.0);
        when(cualidades.getAtaque()).thenReturn(10);
        ModificacionAtaque modificacion = new ModificacionAtaque();
        //Act
        modificacion.modificar(cualidades, 1);
        //Assert
        verify(cualidades, never()).modificarAtaque(1);
    }
}
