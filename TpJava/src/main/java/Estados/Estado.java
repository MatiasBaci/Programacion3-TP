package Estados;

import Pokemones.Cualidades;

public abstract class Estado {

    protected String color;
    protected String nombre;
    protected Cualidades cualidades;
    protected boolean eliminarse =  false;

    public String getNombre() {
        return nombre;
    }

    public String getNombreConColor() {
        return this.color + this.getNombre() + "\u001B[0m";
    }

    public Cualidades getCualidades() {
        return cualidades;
    }

    public void setCualidades(Cualidades cualidades){this.cualidades = cualidades;}

    public boolean debeSerEliminado(){ return this.eliminarse;}
    public abstract boolean puedeAtacar();

    public abstract void aplicarEfectoPasivoDeEstado();
}
