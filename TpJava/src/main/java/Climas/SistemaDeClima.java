package Climas;

import Pokemones.Pokemon;
import org.fiuba.algoritmos3.ServicioDeRandoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fiuba.algoritmos3.Constantes.*;

public class SistemaDeClima {

    private static final Map<String, Clima> climas = new HashMap<>();

    public static void iniciarSistemaDeClima(){
        climas.put(CLIMA_SOLEADO, new ClimaSoleado());
        climas.put(CLIMA_LLUVIA, new ClimaLLuvia());
        climas.put(CLIMA_NEVADO, new ClimaNevado());
        climas.put(CLIMA_TORMENTA_DE_ARENA, new ClimaTormentaArena());
        climas.put(CLIMA_TORMENTA_DE_RAYOS, new ClimaTormentaElectrica());
        climas.put(CLIMA_NIEBLA, new ClimaNiebla());
        climas.put(CLIMA_TORMENTA_DE_NIEVE, new ClimaTormentaNevada());
        climaActual = null;
    }

    public static Clima climaActual;

    public static Clima getClimaActual() {
        return climaActual;
    }

    public static void setClimaActual(String clima) {
        climaActual = climas.get(clima);
    }

    public static void inicializarClimaActual(){
        List<String> claves = new ArrayList<>(climas.keySet());
        int indiceRandom = ServicioDeRandoms.obtenerRandomParaSistemaDeClimas(climas.size());

        climaActual = climas.get(claves.get(indiceRandom));
    }

    public static void aumentarClimaActual(){
        climaActual.aumentarDuracion();
        if(climaActual.getDuracionActual() >= DURACION_MAXIMA_DE_CLIMA + 1){
            climaActual = new ClimaNormal();
        }
    }

    public static void aplicarClimaActual(Pokemon pokemon){
        climaActual.aplicarEfectoClima(pokemon.getCualidades());
        aumentarClimaActual();
    }
}
