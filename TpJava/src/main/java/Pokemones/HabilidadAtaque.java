package Pokemones;

import Tipo.Tipo;
import org.fiuba.algoritmos3.ServicioDeRandoms;

import static org.fiuba.algoritmos3.Constantes.*;

public class HabilidadAtaque extends Habilidad {
    private final Tipo tipo;
    private final int poder;

    private double danioRealizado;

    public HabilidadAtaque(String nombre, Tipo tipo, int poder, int cantidad){
        super(nombre,cantidad);
        this.tipo = tipo;
        this.poder = poder;
        this.danioRealizado = 0;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    public double getDanioRealizado() {
        return danioRealizado;
    }

    private double potenciaDeDanio(Tipo tipoPokemon){
        return this.tipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

    private double calculoAtaqueSegunTipo(Tipo tipoDeUnPokemonPropio, Tipo unTipoPokemonEnemigo) {

        double efectividadTipo = this.potenciaDeDanio(unTipoPokemonEnemigo);
        double mismoTipo = tipoDeUnPokemonPropio.calcularBonusDelMismoTipo(this.tipo);

        double random = ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoAtaqueSegunTipo();

        return efectividadTipo * mismoTipo * random;
    }

    private double calculoCritico() {
        int resultado = ServicioDeRandoms.obtenerRandomParaHabilidadAtaqueCalculoCritico();
        if (resultado < PROBABILIDAD_CRITICO) {
            return NO_CRITICO;
        }
        return CRITICO;
    }

    private double calculoAtaqueSegunEstadisticas(Cualidades cualidadesPropio, Cualidades cualidadesEnemigo) {
        double ataque = (double)cualidadesPropio.getAtaque();
        double defensa = (double)cualidadesEnemigo.getDefensa();
        double poderHabilidad = (double) this.poder;
        double critico = this.calculoCritico();
        double nivel = (double)cualidadesPropio.getNivel();

        return (2.0*nivel*poderHabilidad*ataque*critico/(defensa*5.0)+2.0)/50.0;
    }

        private double atacar(Cualidades cualidadesPokemonPropio, Cualidades cualidadesPokemonEnemigo){
        double danioEstadisticas = this.calculoAtaqueSegunEstadisticas(cualidadesPokemonPropio,cualidadesPokemonEnemigo);
        double danioTipo = this.calculoAtaqueSegunTipo(cualidadesPokemonPropio.getTipo(),cualidadesPokemonEnemigo.getTipo());
        return danioEstadisticas * danioTipo;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        double danio = Math.round(this.atacar(cualidadesPokemonPropio,cualidadesPokemonEnemigo));
        this.danioRealizado = danio;
        cualidadesPokemonEnemigo.recibirDanio(danio);

    }
}
