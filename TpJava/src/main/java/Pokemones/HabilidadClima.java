package Pokemones;

import Climas.SistemaDeClima;

public class HabilidadClima extends Habilidad {
    private final String clima;

    public HabilidadClima(String nombre, String clima, int cantidad){
        super(nombre,cantidad);
        this.clima = clima;
    }

    public String getClima() {
        return clima;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo, Cualidades cualidadesPokemonPropio) {
        SistemaDeClima.setClimaActual(clima);
    }
}
