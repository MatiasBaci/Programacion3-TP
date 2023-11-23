package orgFiuba.tpjava.Model.SerializacionDeserealizacion;

import orgFiuba.tpjava.Model.Pokemones.Habilidad;

public class HabilidadIdsCustom {
    private int id;
    private Habilidad unaHabilidad;

    public HabilidadIdsCustom(int id, Habilidad unaHabilida) {
        this.id = id;
        this.unaHabilidad = unaHabilida;
    }

    public int getId() {return this.id ;}

    public Habilidad getUnaHabilida() {return this.unaHabilidad;}
    public void setId(int id) {this.id = id;}

    public void setUnaHabilidad(Habilidad unaHabilidad) {this.unaHabilidad = unaHabilidad;}

}