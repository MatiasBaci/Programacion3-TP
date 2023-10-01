package org.fiuba.algoritmos3;

public abstract class Item {

    protected String nombre;
    protected int cantidad;
    boolean itemUsado;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        itemUsado = false;
    }

    public abstract void aplicarItem(Pokemon unPokemon);

    public void realizarCasosDeApliacion(Pokemon unPokemon){

        if(itemUsado){
            System.out.println("Solo se puede usar una vez el item");
        }
        else if (cantidad == 0) {
            System.out.println("No tiene este tipo de items");
        }
        else{
            System.out.print("Acaba de seleccionar el siguiente Item: " + nombre);
            aplicarItem(unPokemon);
        }
    }

    public abstract void mostrarItem();

    public String getNombre() {
        return nombre;
    }
}
