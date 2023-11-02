package EstadoTests;

import Estados.EstadoDormido;
import org.fiuba.algoritmos3.ServicioDeRandoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstadoDormidoTest {

    @Test
    public void testPuedeAtacarLuegoDe5TurnosDeMalaSuerte() {
        //Arrange
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(100.0);

            EstadoDormido estadoDormido = new EstadoDormido();
        //Act
            boolean puedeAtacarTurno1 = estadoDormido.puedeAtacar();
            boolean puedeAtacarTurno2 = estadoDormido.puedeAtacar();
            boolean puedeAtacarTurno3 = estadoDormido.puedeAtacar();
            boolean puedeAtacarTurno4 = estadoDormido.puedeAtacar();
            boolean puedeAtacarTurno5 = estadoDormido.puedeAtacar();
        //Assert
            assertFalse (puedeAtacarTurno1);
            assertFalse (puedeAtacarTurno2);
            assertFalse (puedeAtacarTurno3);
            assertFalse (puedeAtacarTurno4);
            assert(puedeAtacarTurno5);
        }
    }

    @Test
    public void testPuedeAtacarConBuenaSuerte() {
        try (MockedStatic<ServicioDeRandoms> mockedRandom = mockStatic(ServicioDeRandoms.class)) {
            mockedRandom.when(ServicioDeRandoms::obtenerRandomParaEstadoPuedeAtacar).thenReturn(0.0);

            EstadoDormido estadoDormido = new EstadoDormido();
        //Act
            boolean puedeAtacar = estadoDormido.puedeAtacar();
        //Assert
            assert(puedeAtacar);
        }
    }
}