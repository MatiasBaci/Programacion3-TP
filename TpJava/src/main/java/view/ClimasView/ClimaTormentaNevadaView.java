package view.ClimasView;

import Climas.Clima;
import view.PokemonesView.PokemonView;

public class ClimaTormentaNevadaView extends ClimaView{

    public ClimaTormentaNevadaView(Clima clima){
        super(clima);
    }

    public void mostrar(PokemonView pokemonView) {
        System.out.println(this.clima.getNombre() + ": Suma 10% al poder total del tipo Nieve y resta 3% de la vida al resto de los tipos.");
        mostrarAplicarEfecto(pokemonView);
        if(pokemonView.getTipoPokemon().verSiEsAbrasivo(this.clima.getNombre())){
            System.out.println("LA VIDA DEL POKEMON SE REDUCE UN 3%.");
        }
    }
}
