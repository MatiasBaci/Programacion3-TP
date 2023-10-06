package Item;

import org.fiuba.algoritmos3.EstadoNormal;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

public class Revivir extends ItemsEstado {

    private Modificacion unaModificacion;


    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public boolean aplicarItem(Pokemon unPokemon) {

        boolean realizo = this.realizarUsadoRevivir(unPokemon.getEstadoActual());
        if(!unPokemon.estaConciente()){
            unPokemon.cambiarseEstado(new EstadoNormal());
        }
        this.unaModificacion.modificar(unPokemon.getEstadisticas(), (int) unPokemon.getVidaMaxima());
        return realizo;
    }
    @Override
    public void mostrarItem() {
        System.out.println(nombre + ": Revive al pokemon con toda su salud - Cantidad: " + cantidad);
    }
}
