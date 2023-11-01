package view;
import org.fiuba.algoritmos3.Estado;

public abstract class EstadoView {

    private Estado estado;

    public EstadoView(Estado estado){
        this.estado = estado;
    }

    protected abstract boolean mostrar();

    protected abstract void mostrarEfectoPasivoDeEstado();



}
