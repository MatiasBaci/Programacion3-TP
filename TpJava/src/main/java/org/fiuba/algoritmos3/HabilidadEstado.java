package org.fiuba.algoritmos3;

public class HabilidadEstado extends Habilidad{

    private Estado unEstado; //Hay que cambiarle el nombre
    public HabilidadEstado(String nombre, int cantidad,Estado unEstado) {
        super(nombre, cantidad);
        this.unEstado = unEstado;
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo, Pokemon unPokemonPropio) {
        // se encarga de que haga el efecto y como tambien que cambie el estado del pokemon enemigo
        this.cantidadDeUsos --;

        if (unPokemonEnemigo.suEstadoEs() == "Normal") {
            // unPokemonEnemigo.cambiarseEstado(new Estado(this.unEstado.getNombre()));
            unPokemonEnemigo.cambiarseEstado(this.unEstado);
        } 

        else {
            System.out.println(this.nombre + " no tuvo efecto porque el pokemon enemigo ya se encuentra " + unPokemonEnemigo.suEstadoEs() + ".");
        }
    }

    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Estado: " + this.unEstado.getNombre());
        System.out.println("Cuantas Etapas: " + 5);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }
}
