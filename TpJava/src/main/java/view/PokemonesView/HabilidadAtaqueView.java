package view.PokemonesView;
import Pokemones.Cualidades;
import Pokemones.HabilidadAtaque;

public class HabilidadAtaqueView extends HabilidadView{

    HabilidadAtaque habilidadAtaque;

    public HabilidadAtaqueView(HabilidadAtaque habilidadAtaque){
        super(habilidadAtaque);
        this.habilidadAtaque = habilidadAtaque;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + this.habilidadAtaque.getNombre());
        System.out.println("Tipo: " + this.habilidadAtaque.getTipo().getNombreConColor());
        System.out.println("Poder: " + this.habilidadAtaque.getPoder());
        System.out.println("Cantidad de usos: " + this.habilidadAtaque.getCantidadDeUsos());
        System.out.println("\n");
    }

    public void mostrarUsarHabilidad(Cualidades cualiadesPokemonActual, Cualidades cualidadesPokemonEnemigo){
        double danio = this.habilidadAtaque.getDanioRealizado();
        System.out.println("El daño infligido de la habiilidad: "+this.habilidadAtaque.getNombre() +" es = " + danio );

    }
}
