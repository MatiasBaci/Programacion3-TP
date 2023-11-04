package Pokemones;

public abstract class Habilidad {

    protected final String nombre;

    protected int cantidadDeUsos;

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio);

    public int getCantidadDeUsos() {
        return cantidadDeUsos;
    }
}
