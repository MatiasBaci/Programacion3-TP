package Climas;

import Pokemones.Pokemon;

import java.util.*;

import static org.fiuba.algoritmos3.Constantes.*;

public class SistemaDeClima {

    private Map<String, Clima> climas;

    private Clima ClimaActual;

    public SistemaDeClima(){
        this.climas = new HashMap<>();
        this.climas.put(CLIMA_SOLEADO, new ClimaSoleado());
        this.climas.put(CLIMA_LLUVIA, new ClimaLLuvia());
        this.climas.put(CLIMA_NEVADO, new ClimaNevado());
        this.climas.put(CLIMA_TORMENTA_DE_ARENA, new ClimaTormentaArena());
        this.climas.put(CLIMA_HURACAN, new ClimaHuracan());
        this.climas.put(CLIMA_TORMENTA_DE_RAYOS, new ClimaTormentaDeRayos());
        this.climas.put(CLIMA_NIEBLA, new ClimaNiebla());
        this.climas.put(CLIMA_TORMENTA_DE_NIEVE, new ClimaTormentaNevada());
        this.climaActual = null;
    }

    private Clima climaActual;

    public Clima getClimaActual() {
        return climaActual;
    }

    public void setClimaActual(Clima climaActual) {
        this.climaActual = climaActual;
    }

    public void inicializarClimaActual(){
        List<String> claves = new ArrayList<>(climas.keySet());
        Random random = new Random();
        int indiceRandom = random.nextInt(climas.size());

        this.climaActual = climas.get(claves.get(indiceRandom));

    }

    public void aumentarClimaActual(){

        this.climaActual.aumentarDuracion();
        if(this.climaActual.getDuracionActual() == this.climaActual.getDuracionMaxima() + 1){
            this.climaActual = new ClimaNormal();
        }
    }

    public void aplicarClimaActual(Pokemon pokemon){
        this.climaActual.aplicarEfectoClima(pokemon);
        this.aumentarClimaActual();
    }


}
