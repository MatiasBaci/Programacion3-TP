import java.util.List;

public class Pokemon {

    //Atributos:
    private String nombre;
    private int nivel;
    private Tipo tipo;
    private String historia;
    private Estadisticas estadisticas;
    private List<Habilidad> habilidades;

    //Metodos:

    public Pokemon(String nombre, int nivel, Tipo tipo, String historia, Estadisticas estadisticas){
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.estadisticas = estadisticas;

    }
    public String getNombre() {

        return nombre;
    }

    public int getNivel() {

        return nivel;
    }

    public Tipo getTipo() {

        return tipo;
    }

    public String getHistoria() {

        return historia;
    }

    public Estadisticas getEstadisticas() {

        return estadisticas;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setNivel(int nivel) {

        this.nivel = nivel;
    }

    public void setTipo(Tipo tipo) {

        this.tipo = tipo;
    }

    public void setHistoria(String historia) {

        this.historia = historia;
    }

    public void setEstadisticas(Estadisticas estadisticas) {

        this.estadisticas = estadisticas;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
}
