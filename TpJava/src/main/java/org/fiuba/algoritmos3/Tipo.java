package org.fiuba.algoritmos3;
public abstract class Tipo {

    private String nombre;

    //Metodos:


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Tipo(String nombre){
        this.nombre = nombre;
    }

    public void calcularEfectividad(Tipo unTipo){
        // Aun falta implementar como abstracto, por ahora trabaje con la clase Hija -> AGUA
        // Cuando se cambie a abstracto, es ahi donde se modificara algunas cosas en las demas clases
    }

}
