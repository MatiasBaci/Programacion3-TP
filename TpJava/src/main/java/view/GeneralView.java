package view;

import org.fiuba.algoritmos3.*;

import static org.fiuba.algoritmos3.Constantes.*;

public class GeneralView {

    private JugadorView jugadorView;

    private JugadorFactory jugadorFactory;

    private ModificacionFactory modificacionFactory;
    private ModificacionView modificacionView;

    public GeneralView(Jugador jugador){
        this.jugadorFactory = new JugadorFactory();
        this.modificacionFactory = new ModificacionFactory();
        this.jugadorView = jugadorFactory.createJugadorView(jugador);

    }

    public JugadorView getJugadorView() {
        return jugadorView;
    }

    public JugadorView getJugadorAdversarioView(){
        return jugadorView.getJugadorAdversarioView();
    }

    public void setJugadorView(Jugador jugador) {
        this.jugadorView = this.jugadorFactory.createJugadorView(jugador);
    }

    public void mostrarMensajeAtacarPokemon() {

        System.out.println("\n");
        System.out.println(ANSI_VERDE + "╔════════════════╗");
                     System.out.println("║ Atacar Pokemon ║");
                     System.out.println("╚════════════════╝" + ANSI_RESET);
        System.out.println("\n");

        this.jugadorView.mostratHabilidadesPokemonActual();
        System.out.println(ANSI_VERDEOSCURO + "Elige una habilidad: " + ANSI_RESET);
    }

    public void mostrarMensajeIntercambiarPokemon() {

        System.out.println("\n");
        System.out.println(ANSI_VERDE + "╔══════════════════════╗");
                     System.out.println("║ Intercambiar Pokemon ║");
                     System.out.println("╚══════════════════════╝" + ANSI_RESET);
        System.out.println("\n");

        this.jugadorView.mostrarPokemones();
        System.out.println(ANSI_VERDEOSCURO + "Ingrese el nombre del pokemon que desea intercambiar: " + ANSI_RESET);
    }

    public void mostrarMensajeCampoBatalla() {

        System.out.println("\n");
        System.out.println(ANSI_VERDEOSCURO + "╔══════════════════╗");
                           System.out.println("║ Campo de Batalla ║");
                           System.out.println("╚══════════════════╝" + ANSI_RESET);
        System.out.println("\n");
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        this.jugadorView.mostrarPokemonActual();
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        this.jugadorView.getJugadorAdversarioView().mostrarPokemonActual();
        System.out.println(ANSI_VERDE + "----------------------------------------------------------------------------------------------------" + ANSI_RESET);
        System.out.println("\n");
        System.out.println(ANSI_VERDEOSCURO + "Oprima una tecla para dejar de ver el campo de batalla: " + ANSI_RESET);
    }

    public void mostrarMensajeRendirse(){

        System.out.println(ANSI_VERDE + "╔═════════════════╗");
                           System.out.println("║ Usted se rindio ║ ");
                           System.out.println("╚═════════════════╝" + ANSI_RESET);
    }

    public void mostrarMensajeOpcionAplicarItem() {

        System.out.println("\n");
        System.out.println(ANSI_VERDE + "╔══════════════╗");
                     System.out.println("║ Aplicar Item ║");
                     System.out.println("╚══════════════╝" + ANSI_RESET);
        System.out.println("\n");

        this.jugadorView.mostratItems();
        System.out.println(ANSI_VERDEOSCURO + "Seleccione el item a aplicar: " + ANSI_RESET);

    }

    public void mostrarMensajeAplicoItem(Jugador jugador, String nombreItem) {

        System.out.println("\n");
        System.out.println(ANSI_VERDE + "╔═════════════════════════════╗");
                     System.out.println("║ Se acaba de aplicar un item ║");
                     System.out.println("╚═════════════════════════════╝" + ANSI_RESET);
        System.out.println("\n");
        System.out.println("El jugador " + jugador.getNombre() + " acaba de usar " + nombreItem + ".");

        System.out.println(ANSI_VERDEOSCURO + "Oprima una tecla para seguir jugando." + ANSI_RESET);
    }

    public void mostrarMensajeIntercambioAlAdversario(){

        System.out.println(ANSI_VERDE + "╔══════════════════════════════════════╗");
                           System.out.println("║ El Adversario Intercambio el Pokemon ║ ");
                           System.out.println("╚══════════════════════════════════════╝");
                           System.out.println("\n");
                           System.out.println(ANSI_VERDEOSCURO + "Es el turno del otro jugador. Oprima una tecla para continuar." + ANSI_RESET);
    }

    public void mostrarMensajeRealizarIntercambio(){
        System.out.println(ANSI_VERDEOSCURO + "Desea Realizar el cambio? Si - No:" + ANSI_RESET);
    }

    public void mostrarMensajeNoSeRealizoIntercambio(){
        System.out.println(ANSI_VERDEOSCURO + "No se realizo el intercambio. Oprima una tecla para continuar." + ANSI_RESET);
    }

    public void mostrarMensajeBienvenida() {

        System.out.println(ANSI_VERDE + "╔═══════════════════════╗");
                     System.out.println("║ BIENVENIDO A POKEMON  ║");
                     System.out.println("╚═══════════════════════╝" + ANSI_RESET   );
    }

    public void mostrarMensajeMenu() {

        System.out.println(ANSI_VERDE);
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║           MENU            ║");
        System.out.println("║═══════════════════════════║");
        System.out.println("║                           ║");
        System.out.println("║ 1 => Rendirse             ║");
        System.out.println("║                           ║");
        System.out.println("║ 2 => Ver campo de batalla ║ ");
        System.out.println("║                           ║");
        System.out.println("║ 3 => Intercambiar Pokemon ║");
        System.out.println("║                           ║");
        System.out.println("║ 4 => Aplicar item         ║");
        System.out.println("║                           ║");
        System.out.println("║ 5 => Atacar               ║");
        System.out.println("╚═══════════════════════════╝");
        System.out.println(ANSI_RESET);

        System.out.println(ANSI_GRISCLARO);
        System.out.println("TURNO: " + this.jugadorView.getNombre());
        System.out.println("POKEMON: " + this.jugadorView.getNombrePokemonActual());
        System.out.println("SELECCIONE UNA OPCION: ");
        System.out.println(ANSI_RESET);
    }

    public void mostrarMensajeOpcionInvalida() {

        System.out.println("\n");
        System.out.println(ANSI_ROJO + "ERROR: NO ES UNA OPCION VALIDAD." + ANSI_RESET);
        System.out.println("\n");

    }

    public void felicitar(Jugador jugador) {
        System.out.println("¡¡Felicidades a " + jugador.getNombre() + "!! Ganaste el juego");
    }

    public void mostrarCasoModicicacion(Modificacion unaModificacion, Pokemon pokemon) {
        this.modificacionView = this.modificacionFactory.createModificacionView(unaModificacion);
        modificacionView.mostrar(pokemon.getCualidades());

    }

    public void mostrarCasoAtques(Pokemon pokemon, Jugador jugadorAversario, String nombreHabilidad) {
        Habilidad habilidadAux = pokemon.getMisHabilidades().get(nombreHabilidad);
        this.jugadorView.getPokemonActualView().mostrarCasoSePuedeAtacar(pokemon, jugadorAversario.getPokemonActual(), habilidadAux);

    }

    public void mostrarEfectoPasivo(){
        this.jugadorView.getPokemonActualView().mostrarEfectoPasivo();
    }

}
