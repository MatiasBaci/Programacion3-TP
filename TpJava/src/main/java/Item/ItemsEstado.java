package Item;

import Estados.Estado;
import Pokemones.Cualidades;

import java.util.Set;

import static org.fiuba.algoritmos3.Constantes.ESTADO_INHABILITADO;

public abstract class ItemsEstado extends Item implements validarItemEstado {

    public ItemsEstado(String unNombre, int cantidad){
        super(unNombre,cantidad);
    }

    public abstract boolean aplicarItem(Cualidades cualidades);

    @Override
    public boolean realizarUsadoCurarTodo(Set<Estado> estadosActuales){
        //!estadosActuales.contains(new EstadoInhabilitado()) --> lo mismo
        if(estadosActuales.stream().noneMatch(unEstado ->  unEstado.getNombre().equals(ESTADO_INHABILITADO))){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean realizarUsadoRevivir(Set<Estado> estadosActuales){
        ////estadosActuales.contains(new EstadoInhabilitado()) no funciona porque no es al misma instancia en memoria
        if(estadosActuales.stream().anyMatch(unEstado -> unEstado.getNombre().equals(ESTADO_INHABILITADO))){
            this.cantidad --;
            return true;
        }
        return false;
    }
    @Override
    public boolean esUnItemDeSoloCampoDeBatalla(){
        return true;
    }
}
