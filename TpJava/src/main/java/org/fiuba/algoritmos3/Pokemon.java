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
    private Map<String, Habilidad> misHabilidades;

    private Estado estadoActual; //Probablemente sea una clase despues


    //Metodos:

    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.nivel = nivel;             // ahora esta en estadisticas deberiamos sacarlo
        this.tipo = Tipo.getTipo(tipo);
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,nivel,velocidad,defensa,ataque);

        this.misHabilidades = new HashMap<>();
        //this.estadoActual = "Normal";

    }
    public String getNombre() {return nombre;}
    public Tipo getTipo() {return tipo;}
    public Estadisticas getEstadisticas() { return estadisticas;}
    public int getVelocidad(){ return estadisticas.getVelocidad();}
    public double obtenerVidaMaxima() { return this.estadisticas.getVidaMaxima();}

    public int getNivel() {return nivel;}

    public String getHistoria() {return historia;}

    public Estado getEstadoActual() {return this.estadoActual ;}

    public Habilidad seleccionarHabilidad(String unaHabilidad){
     /*if(!misHabilidades.containsKey(unaHabilidad)){
            throw new HabilidadNoExisteException();
        } */
        return misHabilidades.get(unaHabilidad);
    }

    public void añadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }

    public void recibirDanio(double damageEnemigo){
        this.estadisticas.reduccionVida(damageEnemigo);
    }

    public void mostrarPokemon(){
        System.out.println(" ");
        System.out.println("Nombre: " + this.nombre);
        this.estadisticas.mostrarEstadisticas();
        System.out.println("Estado: " + this.estadoActual);
        System.out.println(" ");
    }

    public void mostrarHabilidades() {
        this.misHabilidades.forEach((k, v) -> v.mostrarHabilidad());
    }


    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        //this.aplicarEfecto();
        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);//deberia ser un puntero a la habilidad, no una copia
        unaHabilidad.usarHabilidad(pokemonEnemigoActual,this);
        System.out.println("La vida de "+pokemonEnemigoActual.getNombre() + " es = " + pokemonEnemigoActual.getEstadisticas().getVida()); // Esto esta mal debido aque es .get().get()
        pokemonEnemigoActual.getEstadisticas().mostrarEstadisticas();
    }

    //NO SE ESTA USANDO MAS QUE EN LAS CLASES DE CHIRRIDO Y LLAMADARA
    public void modificarEstadisticas(String unaModificacion, int  etapa){
        this.estadisticas.modificarEstadistica(unaModificacion,etapa);
    }

    public void aplicarEfecto(){ //---------> debe ser private por ahora
        //Por ejemplo esto es cuando ya tiene un efecto el pokemon: VENENO, tiene que aplicarse a su vida en cada turno
        //hasta que se recupere con un item
        this.estadoActual.efecto(this);
        // por ejemplo este metodo se puede llamar cada vez que sea el turno del pokemon, cuando intenta atacar se le resta vida
        // pero cuando cambia de pokemon, no debe restarse.
    }

    public void cambiarseEstado(Estado unEstado){
        this.estadoActual = unEstado;
    }


}
