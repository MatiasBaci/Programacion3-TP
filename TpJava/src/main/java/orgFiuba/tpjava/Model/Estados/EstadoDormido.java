package orgFiuba.tpjava.Model.Estados;
import orgFiuba.tpjava.Model.ServicioDeRandoms;

import static orgFiuba.tpjava.Constantes.*;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private final int duracionMaxima;
    private double probabilidadDeDormir;
    private double probabilidadDeDespertar;

    public EstadoDormido(){
        this.nombre = ESTADO_DORMIDO;
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
        this.color = ANSI_FONDO_BLANCO + ANSI_NEGRO;
    }

    public int getTurnosDormido() {
        return this.turnosDormido;
    }

    public int getDuracionMaxima() {
        return this.duracionMaxima;
    }

    public double getProbabilidadDeDormir() {return this.probabilidadDeDormir;}

    public double getProbabilidadDeDespertar(){return this.probabilidadDeDespertar;}

    @Override
    public boolean puedeAtacar(){

        this.probabilidadDeDespertar = Math.round((0.25 + this.turnosDormido * 0.25) * 100.0) / 100.0; //--> para que genere una numero de dos cirfas signficativas
        this.probabilidadDeDormir = ServicioDeRandoms.obtenerRandomParaEstadoPuedeAtacar();


        if (this.turnosDormido >= this.duracionMaxima || this.probabilidadDeDormir <= this.probabilidadDeDespertar){

            this.eliminarse = true;
            this.turnosDormido = 0;
            return true;
        } else {
            this.turnosDormido ++;
            return false;
        }
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}