package org.fiuba.algoritmos3;

import java.util.Random;

public class HabilidadAtaque extends Habilidad {
    private Tipo tipo;
    private int poder;

    public HabilidadAtaque(String nombre, Tipo tipo, int poder, int cantidad){
        super(nombre,cantidad); //Habilidad(String nombre, int cantidadDeUsos
        this.tipo = tipo;
        this.poder = poder;
    }

    // METODOS DE INSTANCIA------------------------------------------------------------
    public Tipo getTipo() {return tipo;} //NO SE USA

    public double getPoder() { return poder; } //NO SE USA

    public String getNombre() {return nombre;}

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.tipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }


    private double calculoAtaqueSegunTipo(Tipo tipoDeUnPokemonPropio, Tipo unTipoPokemonEnemigo) {

        double efectividadTipo = this.potenciaDeDaño(unTipoPokemonEnemigo);
        double mismoTipo = tipoDeUnPokemonPropio.calcularSTAB(this.tipo);

        Random unRandom = new Random();
        double random = ((double)unRandom.nextInt(38)+217 ) / 255.0;

        return efectividadTipo*mismoTipo*random;
    }

    private int calculoCritico() {
        Random unRandom = new Random();
        int resultado = unRandom.nextInt(100);
        if (resultado < 90) {
            return 1;
        }
        return 2;
    }

    private double calculoAtaqueSegunEstadisticas(Estadisticas estadisticasPropio, Estadisticas estadisticasEnemigo) {
        int ataque = estadisticasPropio.getAtaque();
        int defensa = estadisticasEnemigo.getDefensa();
        int poderHabilidad = this.poder;
        int critico = this.calculoCritico();
        int nivel = estadisticasPropio.getNivel();

        return (2.0*nivel*poderHabilidad*ataque*critico/(defensa*5.0)+2.0)/50.0;
    }

    private int atacar(Pokemon unPokemonPropio, Pokemon unPokemonEnemigo){
        double danioEstadisticas = this.calculoAtaqueSegunEstadisticas(unPokemonPropio.getEstadisticas(),unPokemonEnemigo.getEstadisticas());
        double danioTipo = this.calculoAtaqueSegunTipo(unPokemonPropio.getTipo(),unPokemonEnemigo.getTipo());
        return (int)Math.ceil(danioEstadisticas * danioTipo);
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio){
        this.cantidadDeUsos -= 1;
        int danio = this.atacar(unPokemonPropio,unPokemonEnemigo);
        unPokemonEnemigo.recibirDanio(danio);
        System.out.println("El daño infligido de la habiilidad: "+this.nombre +" es = " +danio );
    }

    @Override
    public void mostrarHabilidad(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo.getNombre());
        System.out.println("Poder: " + this.poder);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }





}
