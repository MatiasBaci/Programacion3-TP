package Item;

import org.fiuba.algoritmos3.Estadisticas;
import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.Modificacion;
import org.fiuba.algoritmos3.Pokemon;

import java.util.Objects;

public abstract class Item {

    protected String nombre;
    protected int cantidad;
    protected Modificacion unaModificacion;
    boolean itemUsado;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        itemUsado = false;
    }

    public abstract boolean aplicarItem(Pokemon unPokemon);

    public boolean realizarCasosDeApliacion(Pokemon unPokemon){

        if (cantidad == 0) {
            System.out.println("No tiene este tipo de items");
            return false;
        }
        else if(itemUsado){
            System.out.println("Solo se puede usar una vez el item");
            return false;
        }
        else{
            System.out.print("Acaba de seleccionar el siguiente Item: " + nombre);
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
        if(Objects.equals(unEstado.getNombre(), "Inhabilitado")){
            this.cantidad --;
            this.itemUsado = true;
        }
        else if(!Objects.equals(unEstado.getNombre(), "Normal") && !Objects.equals(unEstado.getNombre(), "Inhabilitado")){
            this.cantidad --;
            this.itemUsado = true;
        }


    }

    public abstract void mostrarItem();

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}
