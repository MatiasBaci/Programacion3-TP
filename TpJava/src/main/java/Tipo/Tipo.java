package Tipo;
import org.fiuba.algoritmos3.Clima;

import static org.fiuba.algoritmos3.Constantes.*;


import java.util.HashMap;
import java.util.Objects;

public abstract class Tipo {

    private static final HashMap<String,Tipo> tipos = new HashMap<>();
    protected String color = null;
    protected String nombre;
    protected HashMap<String,String> tablaEfectividadTipo;

    protected HashMap<String, String> tablaEfectividadClima;

    private double multiplicadorClima;

    public Tipo(){
        this.tablaEfectividadTipo = new HashMap<>();
        this.tablaEfectividadClima = new HashMap<>();
        this.multiplicadorClima = 1;
    }

    // METODOS ESTATICOS------------------------------------------------------------------------------------------:

    static {
        tipos.put(TIPO_FUEGO, new Fuego());
        tipos.put(TIPO_AGUA, new Agua());
        tipos.put(TIPO_NORMAL, new Normal());
        tipos.put(TIPO_PLANTA, new Planta());
        tipos.put(TIPO_ELECTRICO, new Electrico());
        tipos.put(TIPO_LUCHA, new Lucha());
        tipos.put(TIPO_PSIQUICO, new Psiquico());
        tipos.put(TIPO_ROCA, new Roca());
        tipos.put(TIPO_HIELO, new Hielo());
        tipos.put(TIPO_VENENO, new Veneno());
        tipos.put(TIPO_TIERRA, new Tierra());
        tipos.put(TIPO_FANTASMA, new Fantasma());
        tipos.put(TIPO_VOLADOR, new Volador());
        tipos.put(TIPO_BICHO, new Bicho());
        tipos.put(TIPO_DRAGON, new Dragon());
    }

    public static Tipo instanciarUnTipoDe(String nombre){
        return tipos.get(nombre);
    }

    // METODOS DE INSTANCIA-----------------------------------------------------------------------------------------:

    public String getNombre() {
        return nombre;
    }

    public String getNombreConColor(){
        return this.color + this.getNombre() + ANSI_RESET;    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String compararseConTipo(Tipo unTipo){
        if(tablaEfectividadTipo.containsKey(unTipo.getNombre())) {
            return this.tablaEfectividadTipo.get(unTipo.getNombre());
        }
        return RELACION_NORMAL;
    }


    private String compararClima(String nombreClima){
        if(tablaEfectividadClima.containsKey(nombreClima)) {
            return this.tablaEfectividadClima.get(nombreClima);
        }
        return RELACION_NORMAL;
    }

    public double calcularMultiplicadorDeDanio(Tipo unTipo){
        double multiplicadorTipo = this.calcularMultiplicadorTipo(unTipo);
        return multiplicadorTipo * multiplicadorClima;

    }

    public double calcularMultiplicadorTipo(Tipo unTipo){
        double multiplicadorTipo;
        String efectividad = this.compararseConTipo(unTipo);
        multiplicadorTipo = switch (efectividad) {
            case RELACION_FUERTE -> MULTIPLICADOR_FUERTE;
            case RELACION_DEBIL -> MULTIPLICADOR_DEBIL;
            case RELACION_NULA -> MULTIPLICADOR_NULA;
            default -> MULTIPLICADOR_NEUTRAL;
        };
        return multiplicadorTipo;
    }

    public double getMultiplicadorClima() {
        return multiplicadorClima;
    }

    public void calcularMultiplicadorClima(String nombreClima){
        double multiplicadorClima;
        String efectividad = this.compararClima(nombreClima);
        if(Objects.equals(efectividad, RELACION_FUERTE)){
            this.multiplicadorClima = 1.1;
        }
        else{
            this.multiplicadorClima = 1.0;
        }
    }

    public double calcularBonusDelMismoTipo(Tipo unTipo) {
        return this.getNombre().equals(unTipo.getNombre()) ? BONUS_MISMO_TIPO : BONUS_NEUTRAL;
    }

    public abstract void completarTablaEfectividadTipo();

    public abstract void completarTablaEfectividadClima();

}
