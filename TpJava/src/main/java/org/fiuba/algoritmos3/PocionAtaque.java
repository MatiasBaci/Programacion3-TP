package org.fiuba.algoritmos3;

public class PocionAtaque extends Item{

    private Modificacion unaModificacion;

    public PocionAtaque(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }
    

    @Override
    public void aplicarItem(Pokemon unPokemon) {

        this.cantidad --;
        this.itemUsado = true;
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), 1);
    }


    public void mostrarItem() {
        System.out.println(nombre + ": Aumenta 10% el ataque - Cantidad: " + cantidad);
    }
}

