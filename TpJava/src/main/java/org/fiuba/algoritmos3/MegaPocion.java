package org.fiuba.algoritmos3;

public class MegaPocion extends Item{

    private Modificacion unaModificacion;

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public void aplicarItem(Pokemon unPokemon) {

        if(unPokemon.getVida() != unPokemon.getVidaMaxima()) {
            this.cantidad--;
            this.itemUsado = true;
            this.unaModificacion.modificar(unPokemon.getEstadisticas(), 50);
        } else{
            System.out.println(" ");
            System.out.println("El Pokemon tiene toda la vida, no se puede usar este item.");
        }
    }

    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 50 de vida - Cantidad: " + cantidad);
    }
}
