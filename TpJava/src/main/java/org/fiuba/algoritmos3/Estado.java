package org.fiuba.algoritmos3;
//import org.fiuba.algoritmos3.Constantes.*;

public abstract class Estado {

    protected String color;
    protected String nombre;
    protected Cualidades cualidades;
    protected boolean eliminarse =  false; //--> esto esta mas que nada para agregarse en una Lista<Eliimnados>
                                             //--> asi evitamos el error .ConcurrentModificationException

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

    public boolean debeSerEliminado(){ return this.eliminarse;}

    public abstract boolean puedeAtacar();

    public abstract void aplicarEfectoPasivoDeEstado();


}
