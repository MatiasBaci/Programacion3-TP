import java.util.ArrayList;
import java.util.List;

public class Datos {

    //Atributos:

    private List<Pokemon> datosPokemones;

    //Metodos:

    public Datos(){
        List<Habilidad> listaHabilidades = new ArrayList<>();
        List<Pokemon> listaPokemones = new ArrayList<>();
        Habilidad habilidad1 = new Habilidad("Impactrueno");
        Habilidad habilidad2 = new Habilidad("Puño nomral");
        Habilidad habilidad3 = new Habilidad("Electrorayo");
        listaHabilidades.add(habilidad1);
        listaHabilidades.add(habilidad2);
        listaHabilidades.add(habilidad3);
        Pokemon pokemon_1 = new Pokemon("Charmander", 10, new Tipo("Fuego"), "Es de fuego", new Estadisticas(100, 10, 20, 30));
        pokemon_1.setHabilidades(listaHabilidades);
        listaPokemones.add(pokemon_1);
        datosPokemones = listaPokemones;
    }

    public List<Pokemon> getDatosPokemones() {
        return datosPokemones;
    }
}
