package ItemTests;

import Estados.Estado;
import Item.DefensaX;
import Item.Revivir;
import Modificaciones.ModificacionDefensa;
import Modificaciones.ModificacionEstado;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.fiuba.algoritmos3.Constantes.ESTADO_INHABILITADO;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    static class RevivirTest {

        @Test
        public void testAplicarItemCuandoEstaInhabilitado() {
            //Arrange
            Cualidades cualidades = mock(Cualidades.class);
            Set<Estado> estadosActuales = new HashSet<>();
            Estado unEstado = mock(Estado.class);
            when(unEstado.getNombre()).thenReturn(ESTADO_INHABILITADO);
            estadosActuales.add(unEstado);
            when(cualidades.getEstadosActuales()).thenReturn(estadosActuales);
            ModificacionEstado modificacion = mock(ModificacionEstado.class);
            Revivir revivir = new Revivir("Revive", 1, modificacion);

            //Act
            boolean realizo = revivir.aplicarItem(cualidades);

            //Assert
            assert(realizo);
        }

        @Test
        public void testAplicarItemCuandoNoEstaInhabilitado() {
            //Arrange
            Cualidades cualidades = mock(Cualidades.class);
            Set<Estado> estadosActuales = new HashSet<>();
            Estado unEstado = mock(Estado.class);
            when(unEstado.getNombre()).thenReturn("Otro");
            estadosActuales.add(unEstado);
            when(cualidades.getEstadosActuales()).thenReturn(estadosActuales);
            ModificacionEstado modificacion = mock(ModificacionEstado.class);
            Revivir revivir = new Revivir("Revive", 1, modificacion);

            //Act
            boolean realizo = revivir.aplicarItem(cualidades);

            //Assert
            assertFalse(realizo);
        }
    }
}
