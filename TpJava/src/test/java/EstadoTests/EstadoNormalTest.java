package EstadoTests;

import Estados.EstadoNormal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoNormalTest {

    @Test
    public void testPuedeAtacar() {
        //Arrange
        EstadoNormal estadoNormal = new EstadoNormal();
        //Act
        boolean puedeAtacar = estadoNormal.puedeAtacar();
        //Assert
        assert(puedeAtacar);
    }
}