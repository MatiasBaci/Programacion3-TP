import java.util.List;

import javax.swing.plaf.nimbus.State;

public class Pokemon {
    
    private String nombre;
    private int nivel;
    private String tipo; //tiene que ser clase
    private String historia;

    //crear clase stats
    private int vidaMaxima;
    private int vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;
    private List<String> habilidades; //la habilidad tiene que ser clase

    private String estado; //tiene que ser clase
    private Boolean estaVivo;


    public static Pokemon(String nombre, int nivel, String tipo, String historia, int vidaMaxima, int vidaActual, int velocidad, int defensa, int ataque, List<String> habilidades) {

        this.nombre = nombre;
        this.nivel = nivel;
        this.historia = historia;
        this.tipo = tipo;

        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidades = habilidades;

        this.estado = "";
        this.estaVivo = true;
    }

    public void curar(int vida) {
        this.vidaActual += vida;
    }

    public void recibirDanio(int vida) {
        this.vidaActual -= vida;
    }
}
