package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


import java.util.HashMap;

public abstract class Tipo {

    private static HashMap<String,Tipo> tipos = new HashMap<>();
    private String nombre;
    protected HashMap<String,String> tablaEfectividad;

    public Tipo(String nombre){
        this.nombre = nombre;
        this.tablaEfectividad = new HashMap<>();
    }

    // METODOS ESTATICOS------------------------------------------------------------------------------------------:

    static {  // OJO: Esto funciona como un inicializador, Investigarlo mas a detalle para saber si esta correcto o no.
        tipos.put(TIPO_FUEGO, new Fuego("Fuego"));
        tipos.put(TIPO_AGUA, new Agua("Agua"));
        tipos.put(TIPO_NORMAL, new Normal("Normal"));
        tipos.put(TIPO_PLANTA, new Planta("Planta"));
        tipos.put(TIPO_ELECTRICO, new Electrico("Electrico"));
        tipos.put(TIPO_LUCHA, new Lucha("Lucha"));
        tipos.put(TIPO_PSIQUICO, new Psiquico("Psiquico"));
        tipos.put(TIPO_ROCA, new Roca("Roca"));
        tipos.put(TIPO_HIELO, new Hielo("Hielo"));
        tipos.put(TIPO_VENENO, new Veneno("Veneno"));
        tipos.put(TIPO_TIERRA, new Tierra("Tierra"));
        tipos.put(TIPO_FANTASMA, new Fantasma("Fantasma"));
        tipos.put(TIPO_VOLADOR, new Volador("Volador"));
        tipos.put(TIPO_BICHO, new Bicho("Bicho"));
        tipos.put(TIPO_DRAGON, new Dragon("Dragon"));
        // Aqui se pueden agregar mas instancias de otros tipos.
    }

    public static Tipo getTipo(String nombre){ //Posible cambio en el nombre del metodo para más claridad
        return tipos.get(nombre);
    }

    // METODOS DE INSTANCIA-----------------------------------------------------------------------------------------:

    public String getNombre() {
        return nombre;
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
