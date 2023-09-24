package org.fiuba.algoritmos3;
import java.util.HashMap;
// import java.util.List;
import java.util.Map;

public class Pokemon {

    //Atributos:
    private String nombre;
    private int nivel;
    private Tipo tipo; //DEBE SER UNA REFERENCIA A LA CLASE AGUA, NO UNA INSTANCIA DE AGUA
    private String historia;
    private Estadisticas estadisticas;
    private Map<String, HabilidadAtaque> misHabilidades;

    private String estadoActual; //Probablemente sea una clase despues


    //Metodos:

    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = Tipo.getTipo(tipo); //Aqui se le pasa el nombre del tipo (Fuego,Agua,etc
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,velocidad,defensa,ataque);

        this.misHabilidades = new HashMap<>();
        this.estadoActual = "Normal";

    }
    public String getNombre() {return nombre;}
    public int getNivel() {return nivel;}
    public Tipo getTipo() {return tipo;}
    public String getHistoria() {return historia;}
    public Estadisticas getEstadisticas() { return estadisticas;}

    public HabilidadAtaque seleccionarHabilidad(String unaHabilidad){
  /*       if(!misHabilidades.containsKey(unaHabilidad)){
            throw new HabilidadNoExisteException();
        } */
        return misHabilidades.get(unaHabilidad);
    }

    public void añadirHabilidad(String nombre,Tipo unTipo,int poder,int cantidad){
        this.misHabilidades.put(nombre,new HabilidadAtaque(nombre,unTipo,poder,cantidad));
    }

    public void recibirDanio(double damageEnemigo){
        this.estadisticas.reduccionVida(damageEnemigo);
    }

    

    public String getEstadoActual() {
        return estadoActual;
    }

    public void mostrarPokemon(){

        System.out.println(" ");
        System.out.println("Nombre: " + this.nombre);
        this.estadisticas.mostrarEstadisticas();
        System.out.println("Estado: " + this.estadoActual);
        System.out.println(" ");

    }

    public int getVelocidad(){
        return estadisticas.getVelocidad();
    }

    public void mostrarHabilidades() {
        this.misHabilidades.forEach((k, v) -> v.mostrarHabilidad());
    }


    public void usarHabilidad(Pokemon pokemonEnemigoActual, String nombreDeHabilidad){
        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);
        unaHabilidad.usarHabilidad(this,pokemonEnemigoActual);

    }


    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        HabilidadAtaque unaHabilidadAtaque = this.seleccionarHabilidad(nombreDeHabilidad);//deberia ser un puntero a la habilidad, no una copia
        unaHabilidadAtaque.usarHabilidad(this, pokemonEnemigoActual);

/*         System.out.println("La efectividad del ATAQUE "+ unaHabilidadAtaque.getNombre() +" con el Pokemon "+ pokemonEnemigoActual.getNombre()
                + " es: "+ daño);
        System.out.println("El daño total es = " + damage); */
        System.out.println("La vida del enemigo es = " + pokemonEnemigoActual.getEstadisticas().getVida()); // Esto esta mal debido aque es .get().get()

    }


    
}
