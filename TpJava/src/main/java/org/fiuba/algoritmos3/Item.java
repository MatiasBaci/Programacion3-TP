package org.fiuba.algoritmos3;

public abstract class Item {

    protected String nombre;
    protected int cantidad;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public abstract void aplicarItem(Pokemon unPokemon);

    public abstract void mostrarItem();


}
