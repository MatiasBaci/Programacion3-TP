package TpJava.src.test;

public class EstadisticasTest {


    @Test
    public void test01EstadisticasSeCreaConVidaMaxima100() {
        //arrange
        Estadisticas estadisticas = new Estadisticas(100, 10, 10, 10);
        //act
        //assert
        assertEquals(100, estadisticas.getVidaMaxima());
    }


    @Test
    public void test02EstadisticasSeCreaConVelocidad10() {
        //arrange
        Estadisticas estadisticas = new Estadisticas(100, 10, 10, 10);
        //act
        //assert
        assertEquals(10, estadisticas.getVelocidad());
    }

    
    @Test
    public void test03EstadisticasSeCreaConDefensa10() {
        //arrange
        Estadisticas estadisticas = new Estadisticas(100, 10, 10, 10);
        //act
        //assert
        assertEquals(10, estadisticas.getDefensa());
    }


    @Test
    public void test04EstadisticasSeCreaConAtaque10() {
        //arrange
        Estadisticas estadisticas = new Estadisticas(100, 10, 10, 10);
        //act
        //assert
        assertEquals(10, estadisticas.getAtaque());
    }


    @Test
    public void test05EstadisticasSeCreaConVidaMaxima100YSeReduceEn10() {
        //arrange
        Estadisticas estadisticas = new Estadisticas(100, 10, 10, 10);
        //act
        estadisticas.reduccionVida(10);
        //assert
        assertEquals(90, estadisticas.getVidaMaxima());
    }
}
