package view;
import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Habilidad;

public abstract class HabilidadView {

    Habilidad habilidad;

    public HabilidadView(Habilidad habilidad){
        this.habilidad = habilidad;

    }

    public abstract void mostrar();


    public abstract void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo);
}
