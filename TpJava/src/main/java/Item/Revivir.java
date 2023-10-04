package Item;

import Item.Item;
import org.fiuba.algoritmos3.EstadoNormal;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class Revivir extends Item {

    private Modificacion unaModificacion;


    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        realizarUsadoItemsDeEstado(unPokemon.getEstadoActual());
        if(!unPokemon.estaConciente()){
            unPokemon.cambiarseEstado(new EstadoNormal("Normal"));
        }
        unaModificacion.modificar(unPokemon.getEstadisticas(), (int) unPokemon.getVidaMaxima());

        return itemUsado;

    }
    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Revive al pokemon con toda su salud - Cantidad: " + cantidad);
    }
}
