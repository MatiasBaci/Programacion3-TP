package orgFiuba.Model.Estados;

import orgFiuba.Model.Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonBackReference;

import static orgFiuba.Constantes.*;

public abstract class Estado {

    protected String color;
    protected String nombre;
    @JsonBackReference
    protected Cualidades cualidades;
    protected boolean eliminarse =  false;

    public static Estado instaciarUnEstadoDe(String unEstado){
        if(unEstado.equals(ESTADO_DORMIDO)){
            return new EstadoDormido();
        } else if (unEstado.equals(ESTADO_PARALIZADO)) {
            return new EstadoParalizado();
        } else if (unEstado.equals(ESTADO_CONFUSO)) {
            return new EstadoConfuso();
        }
        return new EstadoEnvenenado();
    }
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
