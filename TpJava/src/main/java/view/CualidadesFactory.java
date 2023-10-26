package view;

import Item.Item;
import org.fiuba.algoritmos3.Cualidades;

public class CualidadesFactory {

    public CualidadesView createCualidadesView(Cualidades cualiades) {

        return new CualidadesView(cualiades);
    }
}
