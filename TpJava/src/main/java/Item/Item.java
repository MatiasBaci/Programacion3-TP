package Item;
import static org.fiuba.algoritmos3.Constantes.*;

import org.fiuba.algoritmos3.*;

import java.util.Objects;

public abstract class Item {

    protected String nombre;
    protected int cantidad;
    protected Modificacion unaModificacion;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public boolean realizarCasosDeApliacion(Pokemon unPokemon){

        if (this.cantidad == 0) {
            System.out.println("No tiene este tipo de items");
            return false;
        }
        else{
            System.out.print("Acaba de seleccionar el siguiente Item: " + nombre);
            System.out.println("\n");
            return this.aplicarItem(unPokemon);
        }
    }

    public boolean realizarUsadoItemsDeCuracion(Estadisticas estadistica){
        if(estadistica.getVida() != 0 && estadistica.getVida() != estadistica.getVidaMaxima()){
            this.cantidad --;
            return true;
        }
        return false;
    }

    public boolean realizarUsadoItemsDeEstadisitcas(Estadisticas estadistica){
        if(estadistica.getVida() != 0){
            this.cantidad --;
            return true;
        }
        return false;
    }

    public boolean realizarUsadoItemsDeEstado(Estado unEstado){
        if(Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            return true;
        }
        else if(!Objects.equals(unEstado.getNombre(), ESTADO_NORMAL) && !Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public abstract void mostrarItem();
}
