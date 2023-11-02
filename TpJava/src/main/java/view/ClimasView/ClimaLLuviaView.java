package view.ClimasView;

import Climas.Clima;
import view.PokemonesView.PokemonView;

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
