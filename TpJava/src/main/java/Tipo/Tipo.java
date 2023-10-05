package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


import java.util.HashMap;

public abstract class Tipo {

    private static HashMap<String,Tipo> clasesDeTipos = new HashMap<>();
    private String nombre;
    protected HashMap<String,String> tablaEfectividad;

    public Tipo(String nombre){
        this.nombre = nombre;
        this.tablaEfectividad = new HashMap<>();
    }

    // METODOS ESTATICOS------------------------------------------------------------------------------------------:

    static {
        clasesDeTipos.put(TIPO_FUEGO, new Fuego("Fuego"));
        clasesDeTipos.put(TIPO_AGUA, new Agua("Agua"));
        clasesDeTipos.put(TIPO_NORMAL, new Normal("Normal"));
        clasesDeTipos.put(TIPO_PLANTA, new Planta("Planta"));
        clasesDeTipos.put(TIPO_ELECTRICO, new Electrico("Electrico"));
        clasesDeTipos.put(TIPO_LUCHA, new Lucha("Lucha"));
        clasesDeTipos.put(TIPO_PSIQUICO, new Psiquico("Psiquico"));
        clasesDeTipos.put(TIPO_ROCA, new Roca("Roca"));
        clasesDeTipos.put(TIPO_HIELO, new Hielo("Hielo"));
        clasesDeTipos.put(TIPO_VENENO, new Veneno("Veneno"));
        clasesDeTipos.put(TIPO_TIERRA, new Tierra("Tierra"));
        clasesDeTipos.put(TIPO_FANTASMA, new Fantasma("Fantasma"));
        clasesDeTipos.put(TIPO_VOLADOR, new Volador("Volador"));
        clasesDeTipos.put(TIPO_BICHO, new Bicho("Bicho"));
        clasesDeTipos.put(TIPO_DRAGON, new Dragon("Dragon"));
    }

    public static Tipo obtenerUnTipo(String nombre){ //Posible cambio en el nombre del metodo para más claridad
        return clasesDeTipos.get(nombre);
    }

    // METODOS DE INSTANCIA-----------------------------------------------------------------------------------------:

    public String getNombre() {return this.nombre;}

    private String compararseConTipo(Tipo unTipo){
        if(tablaEfectividad.containsKey(unTipo.getNombre())) {
            return this.tablaEfectividad.get(unTipo.getNombre());
        }
        return RELACION_NORMAL;
    }

    public double calcularMultiplicadorDeDanio(Tipo unTipo){
        double multiplicador;
        String efectividad = this.compararseConTipo(unTipo);
        switch (efectividad){
            case RELACION_FUERTE:
                multiplicador = 2;
                break;
            case RELACION_DEBIL:
                multiplicador = 0.5;
                break;
            case RELACION_NULA:
                multiplicador = 0;
                break;
            default: multiplicador = 1;
        }
        return multiplicador;
    }

    public double calcularSTAB(Tipo unTipo){
        double STAB = 1.0;
        if(this.getNombre().equals(unTipo.getNombre())){
            STAB = 1.5;
        }
        return STAB;
    }

    public abstract void completarTablaEfectividad();

}
