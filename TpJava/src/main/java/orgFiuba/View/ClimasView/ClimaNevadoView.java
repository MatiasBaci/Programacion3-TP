package orgFiuba.View.ClimasView;

import orgFiuba.Model.Climas.Clima;
import orgFiuba.View.PokemonesView.PokemonView;

public class ClimaNevadoView extends ClimaView{

    public ClimaNevadoView(Clima clima){
        super(clima);
    }

    @Override
    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": Suma 10% al poder total del tipo Hielo.");
        mostrarAplicarEfecto(pokemonView);
    }
}
