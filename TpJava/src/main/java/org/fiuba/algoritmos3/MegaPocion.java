package org.fiuba.algoritmos3;

public class MegaPocion extends Item{

    public MegaPocion(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }

    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 50);
        return realizarUsadoItemsDeCuracion(unPokemon.getEstadisticas());

    }

    public void mostrarItem() {
        System.out.println(nombre + ": Restaura 50 de vida - Cantidad: " + cantidad);
    }
}
