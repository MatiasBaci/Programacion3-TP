package org.fiuba.algoritmos3;

import javax.swing.plaf.PanelUI;

public class HabilidadEstadistica extends Habilidad{

    public HabilidadEstadistica(String nombre,int cantidad){
        super(nombre,cantidad);
    }

    private void modificarEstadisticaPokemon(Pokemon unPokemon){
        /* Debemos teneer en cuenta si restaura o no restaura vida o aumenta ataque o disminuye
         - O lo podemos hacer que sea abstracto tambien y crear las clases restauracionHP,etc
         - O podemos hacer que esta clase tenga atributos booleanos y sea algo del estilo
              bool restauracion: false;
              bool aumentarATQ: false;
              bool aumentarDEF: false;
              bool disminuirATQ: false;
              bool disminuirDEF: true;

             pero lo que pasa es que aqui tendremos if :'3 ( PENSAR LUEGO COMO SOLUCIONARLO)

         */
    }
    @Override
    public void efectuarHabilidad(Pokemon unPokemon){

    }
}
