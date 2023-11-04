package ModificacionTests;

import Estados.EstadoParalizado;
import Modificaciones.ModificacionEstado;
import Pokemones.Cualidades;
import org.junit.jupiter.api.Test;

import static org.fiuba.algoritmos3.Constantes.*;
import static org.junit.jupiter.api.Assertions.*;

class ModificacionEstadoTest {

    // TESTS DE INTEGRACION

    @Test
    public void testModificarConVidaMayorA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        cualidades.agregarEstado(new EstadoParalizado());
        ModificacionEstado modificacionEstado = new ModificacionEstado();
        //Act
        modificacionEstado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assert(cualidades.getEstadosActuales().stream().allMatch(unEstado -> unEstado.getNombre().equals(ESTADO_NORMAL)));
    }

    @Test
    public void testModificarConVidaIgualA0() {
        //Arrange
        Cualidades cualidades = new Cualidades(100, 1, 10, 10, 10, "Electrico");
        cualidades.agregarEstado(new EstadoParalizado());
        cualidades.recibirDanio(100);
        assertEquals(0, cualidades.getVida());

        ModificacionEstado modificacionEstado = new ModificacionEstado();
        //Act
        modificacionEstado.modificar(cualidades, (int) cualidades.getVidaMaxima());
        //Assert
        assert(cualidades.getEstadosActuales().stream().allMatch(unEstado -> unEstado.getNombre().equals(ESTADO_INHABILITADO)));
    }
}