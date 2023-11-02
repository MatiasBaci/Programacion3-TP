package orgFiubaAlgoritmos3Tests;

import Pokemones.Habilidad;
import Pokemones.HabilidadAtaque;
import Pokemones.Pokemon;
import Tipo.Tipo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PokemonTest {

    @Test
    public void testPokemonSeCreaConNombre() {
        //Arrange
        Pokemon pikachu = new Pokemon("Pikachu", 1, "Electrico", "Pikachu es un pokemon electrico", 100, 10, 10, 10);
        //Act
        //Assert
        assertEquals("Pikachu", pikachu.getNombre());
    }

    @Test
    public void testPokemonAniadeUnaHabilidad() {
        //Arrange
        Pokemon pikachu = new Pokemon("Pikachu", 1, "Electrico", "Pikachu es un pokemon electrico", 100, 10, 10, 10);
        Habilidad ataqueRapido = mock(Habilidad.class);
        //Act
        pikachu.aniadirHabilidad(ataqueRapido);
        //Assert
        assert(pikachu.getMisHabilidades().containsValue(ataqueRapido));
    }


    // TESTS DE INTEGRACION


    @Test
    public void testCharizardAtacaALucarioConLanzallamas() {
        //Arrange
        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
                153, 120, 105, 129);
        Habilidad lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.instanciarUnTipoDe("Fuego"),90,15);
        charizard.aniadirHabilidad(lanzallamas);
        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
                100, 110, 90, 135);
        //Act
        charizard.atacar(lucario, "Lanzallamas");
        //Assert
        assert(lucario.getCualidades().getVida() < 100);
    }
}
