package org.fiuba.algoritmos3;

// import javax.swing.plaf.PanelUI;

public class HabilidadEstadistica extends Habilidad{

    public HabilidadEstadistica(String nombre,int cantidadDeUsos){
        super(nombre,cantidadDeUsos);
    }

    private void modificarEstadisticaPokemon(Pokemon unPokemon){
        /* Debemos teneer en cuenta si restaura o no restaura vida o aumenta ataque o disminuye
         - O lo podemos hacer que sea abstracto tambien y crear las clases restauracionHP,etc
        posiblemente en las clases como restauracionHP y etc sean interfaces, debido a que items tambien quizas lo implementan
         */
    }
    @Override
    public void usarHabilidad(Pokemon unPokemon, Pokemon pokemonOponente){
        this.cantidadDeUsos -= 1;
        this.modificarEstadisticaPokemon(unPokemon);
    }

    
}
