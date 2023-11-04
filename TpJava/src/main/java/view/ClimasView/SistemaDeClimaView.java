package view.ClimasView;

import Climas.Clima;
import view.PokemonesView.PokemonView;

public class SistemaDeClimaView {

    private ClimaView climaActualView;

    private ClimaFactory climaFactory;

    public SistemaDeClimaView(Clima climaActual){
        this.climaFactory = new ClimaFactory();
        this.climaActualView = climaFactory.createClimaView(climaActual);

    }

    public void setClimaActualView(Clima climaActual){
        this.climaActualView = climaFactory.createClimaView(climaActual);
    }
    public void mostrarEfectosClima(PokemonView pokemonView){

        climaActualView.mostrar(pokemonView);
    }
}
