package org.fiuba.algoritmos3;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    //Atributos:

    private List<Pokemon> datosPokemones;

    //Metodos:

    public Datos(){
        List<Habilidad> listaHabilidades = new ArrayList<>();
        List<Pokemon> listaPokemones = new ArrayList<>();
        Agua ejemplo = new Agua(); //Esto es un ejemplo para que deje de tirar error
        Habilidad habilidad1 = new Habilidad("Impactrueno","algo",ejemplo);
        Habilidad habilidad2 = new Habilidad("Puño nomral","algo",ejemplo);
        Habilidad habilidad3 = new Habilidad("Electrorayo","algo",ejemplo);
        listaHabilidades.add(habilidad1);
        listaHabilidades.add(habilidad2);
        listaHabilidades.add(habilidad3);
        Pokemon pokemon_1 = new Pokemon("Charmander", 10,"Fuego", "Es de fuego", 100, 10, 20, 30);
        pokemon_1.setHabilidades(listaHabilidades);
        listaPokemones.add(pokemon_1);
        datosPokemones = listaPokemones;
    }

    public List<Pokemon> getDatosPokemones() {
        return datosPokemones;
    }
}
