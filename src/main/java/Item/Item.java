package Item;
import static org.fiuba.algoritmos3.Constantes.*;

import org.fiuba.algoritmos3.*;

import java.util.Objects;

public abstract class Item {

    protected String nombre;
    protected int cantidad;
    protected Modificacion unaModificacion;
    protected boolean itemUsado;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.itemUsado = false;
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public boolean realizarCasosDeApliacion(Pokemon unPokemon){

        if (this.cantidad == 0) {
            System.out.println("No tiene este tipo de items");
            return false;
        }
        else if(this.itemUsado){
            System.out.println("Solo se puede usar una vez el item");
            return false;
        }
        else{
            System.out.print("Acaba de seleccionar el siguiente Item: " + this.nombre);
            System.out.println("\n");
            return aplicarItem(unPokemon);
        }
    }

    public void realizarUsadoItemsDeCuracion(Estadisticas estadistica){
        if(estadistica.getVida() != 0 && estadistica.getVida() != estadistica.getVidaMaxima()){
            this.cantidad --;
            this.itemUsado = true;
        }
    }

    public void realizarUsadoItemsDeEstadisitcas(Estadisticas estadistica){
        if(estadistica.getVida() != 0){
            this.cantidad --;
            this.itemUsado = true;
        }


    }

    public void realizarUsadoItemsDeEstado(Estado unEstado){
        if(Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            this.itemUsado = true;
        }
        else if(!Objects.equals(unEstado.getNombre(), ESTADO_NORMAL) && !Objects.equals(unEstado.getNombre(), ESTADO_INHABILITADO)){
            this.cantidad --;
            this.itemUsado = true;
        }


    }

    public abstract void mostrarItem();

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidad() {return this.cantidad;}
}
