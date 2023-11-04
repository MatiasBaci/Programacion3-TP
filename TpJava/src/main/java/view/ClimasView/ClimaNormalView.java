package view.ClimasView;

import Climas.Clima;
import view.PokemonesView.PokemonView;

public class ClimaNormalView extends ClimaView{

    public ClimaNormalView(Clima clima){
        super(clima);
    }

    @Override
    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": No aplica ningun efecto.");
    }
}
