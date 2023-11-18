package Modificaciones;

import Pokemones.Cualidades;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeModificacion")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModificacionVida.class, name = "vida"),
        @JsonSubTypes.Type(value = ModificacionVelocidad.class, name = "velocidad"),
        @JsonSubTypes.Type(value = ModificacionAtaque.class, name = "ataque"),
        @JsonSubTypes.Type(value = ModificacionDefensa.class, name = "defensa"),
})
public interface Modificacion {

    public abstract void modificar(Cualidades cualidades, int etapas);

    public abstract String obtenerNombreModificacion();
}
