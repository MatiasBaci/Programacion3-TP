package view.EstadosView;
import Estados.Estado;

public abstract class EstadoView {

    private Estado estado;

    public EstadoView(Estado estado){
        this.estado = estado;
    }

    public abstract boolean mostrar();

    public abstract void mostrarEfectoPasivoDeEstado();



}
