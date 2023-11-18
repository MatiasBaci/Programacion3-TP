package orgFiuba.Model.Climas;

import orgFiuba.Model.Pokemones.Cualidades;

public abstract class Clima {

    protected String nombre;

    protected int duracionActual;


    public Clima(){
        this.duracionActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionActual() {
        return duracionActual;
    }


    public void aumentarDuracion(){
        duracionActual ++;
    }

    public abstract void aplicarEfectoClima(Cualidades cualidades);

}
