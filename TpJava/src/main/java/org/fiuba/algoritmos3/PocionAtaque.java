package org.fiuba.algoritmos3;

public class PocionAtaque extends Item{

    public PocionAtaque(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }
    

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 1);
        return realizarUsadoItemsDeEstadisitcas(unPokemon.getEstadisticas());
    }


    public void mostrarItem() {
        System.out.println(nombre + ": Aumenta 10% el ataque - Cantidad: " + cantidad);
    }
}

