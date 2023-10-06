package Item;

import org.fiuba.algoritmos3.Estado;

public interface validarItemEstado{
    public abstract boolean realizarUsadoRevivir(Estado unEstado);
    public abstract boolean realizarUsadoCurarTodo(Estado unEstado);
}
