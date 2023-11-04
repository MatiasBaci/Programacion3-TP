package view.PokemonesView;

import Pokemones.Cualidades;

public class CualidadesFactory {

    public CualidadesView createCualidadesView(Cualidades cualiades) {

        return new CualidadesView(cualiades);
    }
}
