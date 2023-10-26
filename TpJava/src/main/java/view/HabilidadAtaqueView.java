package view;
import org.fiuba.algoritmos3.Habilidad;
import org.fiuba.algoritmos3.HabilidadAtaque;
import org.fiuba.algoritmos3.Pokemon;

public class HabilidadAtaqueView extends HabilidadView{

    HabilidadAtaque habilidadAtaque;

    public HabilidadAtaqueView(HabilidadAtaque habilidadAtaqaue){
        super(habilidadAtaqaue);
        this.habilidadAtaque = habilidadAtaqaue;


    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + this.habilidadAtaque.getNombre());
        System.out.println("Tipo: " + this.habilidadAtaque.getTipo().getNombreConColor());
        System.out.println("Poder: " + this.habilidadAtaque.getPoder());
        System.out.println("Cantidad de usos: " + this.habilidadAtaque.getCantidadDeUsos());
        System.out.println("\n");
    }
}
