package view.EstadosView;
import org.fiuba.algoritmos3.Estado;

public abstract class EstadoView {

    private Estado estado;

    public EstadoView(Estado estado){
        this.estado = estado;
    }

    public abstract boolean mostrar();

    public abstract void mostrarEfectoPasivoDeEstado();



}
