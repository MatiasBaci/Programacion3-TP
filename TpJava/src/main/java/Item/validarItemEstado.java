package Item;

import org.fiuba.algoritmos3.Estado;

import java.util.Set;

public interface validarItemEstado{
    public abstract boolean realizarUsadoRevivir(Set<Estado> estadosActuales);
    public abstract boolean realizarUsadoCurarTodo(Set<Estado> estadosActuales);
}
