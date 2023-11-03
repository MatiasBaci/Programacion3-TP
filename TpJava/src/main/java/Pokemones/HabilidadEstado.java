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
        /*if (Objects.equals(cualidadesPokemonEnemigo.suEstadoEs(), ESTADO_NORMAL)) {
            cualidadesPokemonEnemigo.cambiarseEstado(this.unEstado);
        }
        else {
            System.out.println(this.nombre + " no tuvo efecto porque el pokemon enemigo ya se encuentra " + cualidadesPokemonEnemigo.suEstadoEs() + ".");
        }*/
        cualidadesPokemonEnemigo.agregarEstado(this.unEstado); //-------> nueva modificacion
    }

}
