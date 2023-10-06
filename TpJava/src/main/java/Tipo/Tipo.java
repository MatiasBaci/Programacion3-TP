package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


import java.util.HashMap;

public abstract class Tipo {

    private static final HashMap<String,Tipo> tipos = new HashMap<>();
    protected String color = null;
    protected String nombre;
    protected HashMap<String,String> tablaEfectividad;

    public Tipo(){
        this.tablaEfectividad = new HashMap<>();
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
        if(tablaEfectividad.containsKey(unTipo.getNombre())) {
            return this.tablaEfectividad.get(unTipo.getNombre());
        }
        return RELACION_NORMAL;
    }

    public double calcularMultiplicadorDeDanio(Tipo unTipo){
        double multiplicador;
        String efectividad = this.compararseConTipo(unTipo);
        multiplicador = switch (efectividad) {
            case RELACION_FUERTE -> MULTIPLICADOR_FUERTE;
            case RELACION_DEBIL -> MULTIPLICADOR_DEBIL;
            case RELACION_NULA -> MULTIPLICADOR_NULA;
            default -> MULTIPLICADOR_NEUTRAL;
        };
        return multiplicador;
    }

    public double calcularBonusDelMismoTipo(Tipo unTipo) {
        return this.getNombre().equals(unTipo.getNombre()) ? BONUS_MISMO_TIPO : BONUS_NEUTRAL;
    }

    public abstract void completarTablaEfectividad();

}
