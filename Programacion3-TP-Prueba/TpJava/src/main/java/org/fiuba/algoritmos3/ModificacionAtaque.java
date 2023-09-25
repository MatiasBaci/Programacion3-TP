package org.fiuba.algoritmos3;

public class ModificacionAtaque implements Modificacion{ //implementsModificable

   /*private  int maximo;
    private  int actual;
   public void modificar(int etapas){
       this.actual += this.actual * etapas * 0.1;
   }*/ // Lo habia pensado como clases pero al ver que eran iguales todas y que si engloba un Abstracta, no tendrian comportamiento

    //Ahora actuara como auxiliar, tendra sentido?
    @Override
    public void modificar(Estadisticas unaEstadistica,int etapas){
        unaEstadistica.modificarAtaque(etapas);
    }
}
