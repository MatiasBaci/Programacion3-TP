package orgFiuba.Model.Pokemones;

import orgFiuba.Model.Estados.Estado;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonTypeName("estado")
@JsonIgnoreProperties
public class HabilidadEstado extends Habilidad{

    private final Estado unEstado;
    @JsonCreator
    public HabilidadEstado(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("cantidad") int cantidad,
            @JsonProperty("estado") Estado unEstado) {
        super(nombre, cantidad);
        this.unEstado = unEstado;
    }

    public Estado getUnEstado() {
        return unEstado;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio) {
        this.cantidadDeUsos --;
        cualidadesPokemonEnemigo.agregarEstado(this.unEstado);
    }
}
