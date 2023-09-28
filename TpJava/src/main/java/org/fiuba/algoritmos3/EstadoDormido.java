package org.fiuba.algoritmos3;

public class EstadoDormido extends Estado{

    private int turnosPedridos;

    public EstadoDormido(String nombre, int cantidad){
        super(nombre, cantidad);
        turnosPedridos = 0;
    }


    public void setTurnosPedridos(int turnosPedridos){
        this.turnosPedridos = turnosPedridos;

    }

    public void efectoActivo(Pokemon unPokemon){

        System.out.println("El Pokemon esta dormido y no puede usar habilidades, se pierde el turno.");

    }

    public void efectoPasivo(Pokemon unPokemon){
        if(duracionMaxima != duracionActual){
            duracionActual ++;
            System.out.println("El pokemon esta dormido");

        }
        else{

            unPokemon.cambiarseEstado(new EstadoNormal("Normal", 0));
            System.out.println("El pokemon ya no esta dormido");
        }
    }

}
