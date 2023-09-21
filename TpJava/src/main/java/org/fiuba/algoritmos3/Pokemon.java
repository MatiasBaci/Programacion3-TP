package org.fiuba.algoritmos3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {

    //Atributos:
    private String nombre;
    private int nivel;
    private Tipo tipo; //DEBE SER UNA REFERENCIA A LA CLASE AGUA, NO UNA INSTANCIA DE AGUA
    private String historia;
    private Estadisticas estadisticas;
    private Map<String,Habilidad> misHabilidades;


    //Metodos:

    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = Tipo.getTipo(tipo); //Aqui se le pasa el nombre del tipo (Fuego,Agua,etc
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,velocidad,defensa,ataque);

        this.misHabilidades = new HashMap<>();

    }
    public String getNombre() {return nombre;}
    public int getNivel() {return nivel;}
    public Tipo getTipo() {return tipo;}
    public String getHistoria() {return historia;}
    public Estadisticas getEstadisticas() { return estadisticas;}

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public void añadirHabilidad(String nombre,Tipo unTipo){
        this.misHabilidades.put(nombre,new Habilidad(nombre,unTipo));
    }

    public void recibirDaño(double damageEnemigo){
        this.estadisticas.reduccionVida(damageEnemigo);
    }

    public void atacar(Pokemon pokemonEnemigoActual,Habilidad unaHabilidad) {
        CalculoAtaque unCalculo = new CalculoAtaque(this.estadisticas,pokemonEnemigoActual.getEstadisticas());
        double damage = unCalculo.calculoAtaqueTotal(pokemonEnemigoActual.getTipo(),this.getTipo(),unaHabilidad,this.getNivel());
        double daño = unaHabilidad.potenciaDeDaño(pokemonEnemigoActual.getTipo()); //Aqui se calcula la efectividad

        pokemonEnemigoActual.recibirDaño(damage);

        System.out.println("La efectividad del ATAQUE "+ unaHabilidad.getNombre() +" con el Pokemon "+ pokemonEnemigoActual.getNombre()
                + " es: "+ daño);
        System.out.println("El daño total es = " + damage);
        System.out.println("La vida del enemigo es = " + pokemonEnemigoActual.getEstadisticas().getVidaMaxima()); // Esto esta mal debido aque es .get().get()

    }
}
