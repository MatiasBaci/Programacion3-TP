package view.PokemonesView;

import Pokemones.Cualidades;
import view.EstadosView.*;

import java.util.HashSet;
import java.util.Set;

import static org.fiuba.algoritmos3.Constantes.*;

public class CualidadesView {

    private Cualidades cualidades;

    private Set<EstadoView> estadosActualesView;

    private EstadoFacory estadoFacory;

    public CualidadesView(Cualidades cualidades){
        this.cualidades = cualidades;
        this.estadosActualesView = new HashSet<>();
        this.estadoFacory = new EstadoFacory();
        this.cualidades.getEstadosActuales().forEach(estado -> estadosActualesView.add(estadoFacory.createEstadoView(estado)));
    }

    public void mostrar(){
        System.out.println(" Tipo: " + this.cualidades.getTipo().getNombreConColor()); //Eliminar
        System.out.println(
                " Nivel: " + this.cualidades.getNivel() + " --" +
                        " HP: " + ANSI_ROJO + (int)this.cualidades.getVida() + ANSI_RESET + " --" +
                        " Velocidad: " + ANSI_AMARILLO + this.cualidades.getVelocidad() + ANSI_RESET + " --" +
                        " Defensa: " + ANSI_CELESTE + this.cualidades.getDefensa() + ANSI_RESET + " --"  +
                        " Ataque: " + ANSI_MARRON + this.cualidades.getAtaque() + ANSI_RESET);
        System.out.println(" Estado: ");
        this.cualidades.getEstadosActuales().forEach(estado -> {
            System.out.println(" " + estado.getNombreConColor());
        });
    }

    public boolean atacarConEstadosActuales(){
        boolean puedeAtacarConSusEstados = this.estadosActualesView.stream().allMatch(estado -> estado.mostrar());
        //this.estadosActualesView.removeIf(Estado::debeSerEliminado); --> no funciona aqui
        return puedeAtacarConSusEstados;
    }

    public Set<EstadoView> getEstadosActualesView(){
        return estadosActualesView;
    }

}
