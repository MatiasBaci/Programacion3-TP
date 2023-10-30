package view;

import Tipo.Tipo;
import org.fiuba.algoritmos3.Cualidades;
import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.EstadoNormal;

import java.util.Set;

public class CualidadesView {

    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;

    private double nivel;

    private Tipo tipo;

    private Set<Estado> estadosActuales;

    public CualidadesView(Cualidades cualidades){
        this.vidaActual = cualidades.getVida();
        this.velocidad = cualidades.getVelocidad();
        this.defensa = cualidades.getDefensa();
        this.ataque = cualidades.getAtaque();
        this.nivel = cualidades.getNivel();
        this.tipo = cualidades.getTipo();
        this.estadosActuales = cualidades.getEstadosActuales();
    }

    public void mostrar(){
        System.out.println(" Tipo: " + this.tipo.getNombreConColor());
        System.out.println(
                " Nivel: " + this.nivel + " --" +
                        " HP: " + (int)this.vidaActual + " --" +
                        " Velocidad: " + this.velocidad + " --" +
                        " Defensa: " + this.defensa + " --" +
                        " Ataque: " + this.ataque);
        //System.out.println(" Estado: " + this.estadoActual.getNombreConColor() + "\n");
        this.estadosActuales.forEach(estado -> {
            System.out.println("Estado: "+ estado.getNombreConColor() + "\n");
        });
    }
}
