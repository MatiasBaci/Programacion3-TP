package Estados;

import org.fiuba.algoritmos3.ServicioDeRandoms;

import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoConfuso extends Estado{

    private int turnosConfuso;
    private final int duracionMaxima;
    private boolean confundido;
    private double danioPorConfusion;


    public EstadoConfuso(){
        this.nombre = ESTADO_CONFUSO;
        this.duracionMaxima = 3;
        this.turnosConfuso = 0;
        this.color = ANSI_FONDO_ROJO + ANSI_NEGRO;
    }

    public int getTurnosConfuso() {
        return turnosConfuso;
    }

    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public boolean isConfundido() {
        return confundido;
    }

    public double getDanioPorConfusion() {
        return danioPorConfusion;
    }

    @Override
    public boolean puedeAtacar(){

        if(this.turnosConfuso >= this.duracionMaxima){
            //this.cualidades.cambiarseEstado(new EstadoNormal()); // cambiarlo------------>
            //this.cualidades.eliminarEstado(this);
            this.eliminarse = true;
            return true;
        }
        this.turnosConfuso++;

        double probabilidad = ServicioDeRandoms.obtenerRandomParaEstadoPuedeAtacar(); //Numero random de 0(incluyendo) a 1(excluyendo)
        this.confundido = probabilidad <= PROBABILIDAD_DE_HERIRSE; // quiero que se guarde para luego usarlo en aplicar EfectoPasivoEstado

        if(confundido){
            this.danioPorConfusion = PORCENTAJE_DANIO_CONFUSO * this.cualidades.getVidaMaxima();
            this.cualidades.recibirDanio(danioPorConfusion);
            //this.cualidades.actualizarEstados(); // para que todos los estados sepan que se actualizaron
            return false;
        } else return true;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
