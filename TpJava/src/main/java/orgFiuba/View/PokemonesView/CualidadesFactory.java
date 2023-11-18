package orgFiuba.View.PokemonesView;

import orgFiuba.Model.Pokemones.Cualidades;

public class CualidadesFactory {

    public CualidadesView createCualidadesView(Cualidades cualiades) {

        return new CualidadesView(cualiades);
    }
}
