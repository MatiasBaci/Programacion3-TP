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
        unEstado.efecto(unPokemonEnemigo);
        unPokemonEnemigo.cambiarseEstado(this.unEstado);
    }

    @Override
    public void mostrarHabilidad() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Estado: " + "ENVENENA");
        System.out.println("Cuantas Etapas: " + 5);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }
}
