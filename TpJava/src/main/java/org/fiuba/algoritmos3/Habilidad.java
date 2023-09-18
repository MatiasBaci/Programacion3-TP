package org.fiuba.algoritmos3;
public class Habilidad {
    private String nombre;

    private String tipo; //-> posiblemente una clase

    private Agua untipo; // -> de clase Tipo pero para el ejemplo sera Agua directamente
    //Metodos:
    public String getTipo() {return tipo;} // para el ejemplo

    public Habilidad(String nombre,String tipo,Agua ejemplo){ // SE TIENE QUE QUITAR EL AGUA DEL EJEMPLO DESPUES
        this.nombre = nombre;
        this.tipo = tipo;
        this.untipo = ejemplo;
    }

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.untipo.calcularEfectividad(tipoPokemon);

    }


}
