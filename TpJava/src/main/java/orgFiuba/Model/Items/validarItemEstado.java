package orgFiuba.Model.Items;

import orgFiuba.Model.Estados.Estado;

import java.util.Set;

public interface validarItemEstado{
    public abstract boolean realizarUsadoRevivir(Set<Estado> estadosActuales);
    public abstract boolean realizarUsadoCurarTodo(Set<Estado> estadosActuales);
}
