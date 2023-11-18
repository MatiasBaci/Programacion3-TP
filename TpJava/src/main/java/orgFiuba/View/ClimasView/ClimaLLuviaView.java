package orgFiuba.View.ClimasView;

import orgFiuba.Model.Climas.Clima;
import orgFiuba.View.PokemonesView.PokemonView;

public class ClimaLLuviaView extends ClimaView{

    public ClimaLLuviaView(Clima clima){
        super(clima);
    }

    @Override
    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": Suma 10% al poder total del tipo Agua y Planta");
        mostrarAplicarEfecto(pokemonView);
    }
}
