package org.fiuba.algoritmos3;
public class HabilidadAtaque { //Posiblemente se convierta en un abstraccto y que los ataques en si sean las hijas clases
                               // Osea crear una Clase LLAMARADA

    private String nombre;
    private Tipo untipo;
    private int cantidad;
    private int poder;

    public HabilidadAtaque(String nombre, Tipo tipo, int poder, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.untipo = tipo;
        this.poder = poder;
    }

    // METODOS DE INSTANCIA------------------------------------------------------------
    public Tipo getTipo() {return untipo;}

    public String getNombre() {return nombre;}

    public double getPoder() { return poder; }

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.untipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

    public void atacar(Pokemon unPokemonEnemigo){
        //Posible problema porque necesita el nivel actual de pokemon Propio, como obtengo eso? :v, si es por parametro cambiaria la firma
    }
    // AQUI SE DEBE LLAMAR CALCULOATAQUE PORQUE HABILIDADATAQUE USA CALCULOATAQUE
    // porque cada HABILIDAD VA A TENER SU FORMA DISTINTA DE ATACAR A LOS POKEMONS
}
