package Pokemones;

import Estados.Estado;

public class HabilidadEstado extends Habilidad{

    private final Estado unEstado;
    public HabilidadEstado(String nombre, int cantidad,Estado unEstado) {
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
