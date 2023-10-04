package Tipo;

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
        tipos.put("Fuego", new Fuego("Fuego"));
        tipos.put("Agua", new Agua("Agua"));
        tipos.put("Normal", new Normal("Normal"));
        tipos.put("Planta", new Planta("Planta"));
        tipos.put("Electrico", new Electrico("Electrico"));
        tipos.put("Lucha", new Lucha("Lucha"));
        tipos.put("Psiquico", new Psiquico("Psiquico"));
        tipos.put("Roca", new Roca("Roca"));
        tipos.put("Hielo", new Hielo("Hielo"));
        tipos.put("Veneno", new Veneno("Veneno"));
        tipos.put("Tierra", new Tierra("Tierra"));
        tipos.put("Fantasma", new Fantasma("Fantasma"));
        tipos.put("Volador", new Volador("Volador"));
        tipos.put("Bicho", new Bicho("Bicho"));
        tipos.put("Dragon", new Dragon("Dragon"));
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
        return "Normal";
    }

    public double calcularMultiplicadorDeDanio(Tipo unTipo){
        double multiplicador;
        String efectividad = this.compararseConTipo(unTipo);
        switch (efectividad){
            case "Fuerte":
                multiplicador = 2;
                break;
            case "Debil":
                multiplicador = 0.5;
                break;
            case "Nula":
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
