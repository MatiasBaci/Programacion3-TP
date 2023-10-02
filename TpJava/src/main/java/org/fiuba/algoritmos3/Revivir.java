package org.fiuba.algoritmos3;

public class Revivir extends Item{

    private Modificacion unaModificacion;


    public Revivir(String nombre, int cantidad, Modificacion unaModificacion){
        super(nombre, cantidad);
        this.unaModificacion = unaModificacion;
    }


    @Override
    public void aplicarItem(Pokemon unPokemon) {
        if(!unPokemon.estaVivo()) {
            this.cantidad --;
            this.itemUsado = true;
            unaModificacion.modificar(unPokemon.getEstadisticas(), (int) unPokemon.getVidaMaxima());
            unPokemon.cambiarseEstado(new EstadoNormal("Normal"));

        }else{
            System.out.println(" ");
            System.out.println("El Pokemon no se puede revivir ya que no esta Inhabilitado");
        }
    }
    

    public void mostrarItem() {
        System.out.println(nombre + ": Revive al pokemon con toda su salud - Cantidad: " + cantidad);
    }
}
