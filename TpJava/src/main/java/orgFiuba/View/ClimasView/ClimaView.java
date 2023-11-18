package orgFiuba.View.ClimasView;

import orgFiuba.Model.Climas.Clima;
import orgFiuba.View.PokemonesView.PokemonView;

import java.util.Objects;

import static orgFiuba.Constantes.RELACION_FUERTE;

public abstract class ClimaView {

    protected Clima clima;
    public ClimaView(Clima clima){
        this.clima = clima;
    }

    public abstract void mostrar(PokemonView pokemonView);

    protected void mostrarAplicarEfecto(PokemonView pokemonView){

        if(Objects.equals(pokemonView.getTipoPokemon().compararClima(this.clima.getNombre()), RELACION_FUERTE)){
            System.out.println("EL CLIMA FAVORECE A TU POKEMON!! Sus ataques son 10% más fuertes.");
        }
    }
}
