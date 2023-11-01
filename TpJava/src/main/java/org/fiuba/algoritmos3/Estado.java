package org.fiuba.algoritmos3;
//import org.fiuba.algoritmos3.Constantes.*;

public abstract class Estado {

    protected String color;
    protected String nombre;
    protected Cualidades cualidades;

    public String getNombre() {
        return nombre;
    }

    public String getNombreConColor() { //podría ser una interfaz porque Tipo tambien tiene este metodo
        return this.color + this.getNombre() + "\u001B[0m"; //no me toma el ANSI_RESET
    }

    public Cualidades getCualidades() {
        return cualidades;
    }

    public void setCualidades(Cualidades cualidades){this.cualidades = cualidades;}

    public abstract boolean puedeAtacar();

    public abstract void aplicarEfectoPasivoDeEstado();
}
