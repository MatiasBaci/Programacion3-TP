package org.fiuba.algoritmos3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {

    //Atributos:
    private String nombre;
    private int nivel;
    private Tipo tipo;

    private Agua untipo; // esto es solo para probar, luego se eliminara poque es hija de Tipo ( por ahora )
    private String historia;
    private Estadisticas estadisticas;
    private List<Habilidad> habilidades; //Posiblemente se va ir o no.

    private Map<String,Habilidad> misHabilidades;


    //Metodos:

    public Pokemon(String nombre, int nivel,String tipo, String historia,int vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = new Tipo(tipo);
        this.untipo = new Agua(); // De prueba -> Luego se elimina.
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,velocidad,defensa,ataque);

        this.misHabilidades = new HashMap<>();

    }
    public String getNombre() {return nombre;}
    public int getNivel() {return nivel;}
    public Tipo getTipo() {return tipo;}
    public String getHistoria() {return historia;}
    public Estadisticas getEstadisticas() { return estadisticas;}
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }


    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public void añadirHabilidad(String nombre,String tipo){ //Este metodo no es flexible para añadir habilidades sin tipo.
        this.misHabilidades.put(nombre,new Habilidad(nombre,tipo,new Agua())); // esto es un ejemplo de ahi se sacara el new.AGUA
    }

    public void atacar(Pokemon pokemonEnemigoActual,Habilidad ataque) {
        double daño = ataque.potenciaDeDaño(pokemonEnemigoActual.getTipo()); //Aqui se calcula la efectividad
        System.out.println("La efectividad de "+ pokemonEnemigoActual.getNombre()+" con el ATAQUE de tipo "+ ataque.getTipo()
                + "es: "+ daño);
    }
}
