package view.PokemonesView;

import Pokemones.Cualidades;
import Pokemones.HabilidadClima;

public class HabilidadClimaView extends HabilidadView{

    HabilidadClima habilidadClima;

    public HabilidadClimaView(HabilidadClima habilidadClima) {
        super(habilidadClima);
        this.habilidadClima = habilidadClima;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + this.habilidadClima.getNombre());
        System.out.println("Clima: " + this.habilidadClima.getClima());
        System.out.println("Cantidad de usos: " + this.habilidadClima.getCantidadDeUsos());
        System.out.println("\n");
    }

    @Override
    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo) {
        System.out.println("El clima actual es: " + this.habilidadClima.getClima());
    }
}
