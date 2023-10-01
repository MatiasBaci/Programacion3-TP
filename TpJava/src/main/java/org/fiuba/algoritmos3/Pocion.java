package org.fiuba.algoritmos3;

public class Pocion extends Item{

    private Modificacion unaModificacion;

    public Pocion(String nombre, int cantidad, Modificacion modificar){
        super(nombre, cantidad);
        this.unaModificacion = modificar;
    }

    public void aplicarItem(Pokemon unPokemon){

        if(unPokemon.getVida() != unPokemon.getVidaMaxima()) {
            this.cantidad--;
            this.itemUsado = true;
            this.unaModificacion.modificar(unPokemon.getEstadisticas(), 25);
        } else{
            System.out.println(" ");
            System.out.println("El Pokemon tiene toda la vida, no se puede usar este item.");
        }

    }

    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 25 de vida - Cantidad: " + cantidad);
    }
}
