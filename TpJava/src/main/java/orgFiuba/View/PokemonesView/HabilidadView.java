package orgFiuba.View.PokemonesView;
import orgFiuba.Model.Pokemones.Cualidades;
import orgFiuba.Model.Pokemones.Habilidad;

public abstract class HabilidadView {

    Habilidad habilidad;

    public HabilidadView(Habilidad habilidad){
        this.habilidad = habilidad;

    }

    public abstract void mostrar();


    public abstract void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo);
}
