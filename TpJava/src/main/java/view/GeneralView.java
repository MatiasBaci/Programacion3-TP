package view;

import org.fiuba.algoritmos3.*;

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
        System.out.println("╔════════════════╗");
        System.out.println("║ Atacar Pokemon ║");
        System.out.println("╚════════════════╝");
        System.out.println("\n");

        this.jugadorView.mostratHabilidadesPokemonActual();
        System.out.println("Elige una habilidad: ");
    }

    public void mostrarMensajeIntercambiarPokemon() {

        System.out.println("\n");
        System.out.println("╔══════════════════════╗");
        System.out.println("║ Intercambiar Pokemon ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("\n");

        System.out.println("Los pokemones disponibles de " + this.jugadorView.getNombre() + " son: ");
        this.jugadorView.mostrarPokemones();
        System.out.println("Ingrese el nombre del pokemon: ");
    }

    public void mostrarMensajeCampoBatalla() {

        System.out.println("\n");
        System.out.println("╔══════════════════╗");
        System.out.println("║ Campo de Batalla ║");
        System.out.println("╚══════════════════╝");
        System.out.println("\n");

        this.jugadorView.mostrarPokemonActual();
        this.jugadorView.getJugadorAdversarioView().mostrarPokemonActual();
        System.out.println("Oprima una tecla para dejar de ver el campo de batalla: ");
    }

    public void mostrarMensajeRendirse(){

        System.out.println("╔═════════════════╗");
        System.out.println("║ Usted se rindio ║ ");
        System.out.println("╚═════════════════╝");
    }

    public void mostrarMensajeOpcionAplicarItem() {

        System.out.println("\n");
        System.out.println("╔══════════════╗");
        System.out.println("║ Aplicar Item ║");
        System.out.println("╚══════════════╝");
        System.out.println("\n");

        this.jugadorView.mostratItems();
        System.out.println("Seleccione el item a aplicar: ");

    }

    public void mostrarMensajeAplicoItem(Jugador jugador, String nombreItem) {

        System.out.println("\n");
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ Se acaba de aplicar un item ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("\n");
        System.out.println("El jugador " + jugador.getNombre() + " acaba de usar " + nombreItem + ".");
        System.out.println("Oprima una tecla para seguir jugando.");
    }

    public void mostrarMensajeIntercambioAlAdversario(){

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║ El Adversario Intercambio el Pokemon ║ ");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("\n");
    }

    public void mostrarMensajeBienvenida() {

        System.out.println("╔═══════════════════════╗");
        System.out.println("║ BIENVENIDO A POKEMON  ║");
        System.out.println("╚═══════════════════════╝");
    }

    public void mostrarMensajeMenu() {

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

        System.out.println("TURNO: " + this.jugadorView.getNombre());
        System.out.println("POKEMON: " + this.jugadorView.getNombrePokemonActual());
        System.out.println("SELECCIONE UNA OPCION: ");


    }

    public void mostrarMensajeOpcionInvalida() {

        System.out.println("\n");
        System.out.println("╔═════════════════╗");
        System.out.println("║ Opcion Invalida ║");
        System.out.println("╚═════════════════╝");
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
}
