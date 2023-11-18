package orgFiuba.View.ClimasView;

import orgFiuba.Model.Climas.Clima;
import orgFiuba.View.PokemonesView.PokemonView;

public class ClimaNormalView extends ClimaView{

    public ClimaNormalView(Clima clima){
        super(clima);
    }

    @Override
    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": No aplica ningun efecto.");
    }
}
