package org.fiuba.algoritmos3;
//import org.fiuba.algoritmos3.Constantes.*;

public abstract class Estado {


    protected String color;
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public String getNombreConColor() { //podría ser una interfaz porque Tipo tambien tiene este metodo
        return this.color + this.getNombre() + "\u001B[0m"; //no me toma el ANSI_RESET
    }


    public abstract boolean puedeAtacar(Cualidades cualidades);

    public abstract void aplicarEfectoPasivoDeEstado(Cualidades cualidades);
}
