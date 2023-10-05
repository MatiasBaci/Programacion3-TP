package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;
import Item.*;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

public class Datos {

    //Atributos:
    private Map<String, Pokemon> mochilaJugador1;
    private Map<String, Pokemon> mochilaJugador2;
    private Map<String, Item> itemsJugador1;
    private Map<String, Item> itemsJugador2;

    //Metodos:

    public Datos() {

        this.mochilaJugador1 = new HashMap<>();
        this.mochilaJugador2 = new HashMap<>();
        this.itemsJugador1 = new HashMap<>();
        this.itemsJugador2 = new HashMap<>();

        this.InicialzarPokemonesJugador1();
        this.InicialzarPokemonesJugador2();
    }

    private void InicialzarPokemonesJugador1(){

        Pokemon squirtle = new Pokemon("Squirtle", 50, "Agua", "El caparazón de Squirtle no sólo lo protege; su forma redondeada y sus hendiduras reducen su resistencia al agua y le permiten nadar más rápido.",
        119, 63, 85, 70);
        Habilidad chorroDeAgua = new HabilidadAtaque("ChorroDeAgua",Tipo.getTipo("Agua"),40,25);
        squirtle.añadirHabilidad(chorroDeAgua);
        Habilidad cabezazo = new HabilidadAtaque("Cabezazo",Tipo.getTipo("Normal"),130,10);
        squirtle.añadirHabilidad(cabezazo);
        Habilidad defensaFerrea = new HabilidadEstadistica("DefensaFerrea", 15, true, 2, new ModificacionDefensa());
        squirtle.añadirHabilidad(defensaFerrea);
        this.mochilaJugador1.put(squirtle.getNombre(), squirtle);


        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
        153, 120, 105, 129);
        Habilidad tajoAereo = new HabilidadAtaque("TajoAereo",Tipo.getTipo("Volador"),75,15);
        charizard.añadirHabilidad(tajoAereo);
        Habilidad lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.getTipo("Fuego"),90,15);
        charizard.añadirHabilidad(lanzallamas);
        Habilidad garraDragon = new HabilidadAtaque("GarraDragon",Tipo.getTipo("Dragon"),80,15);
        charizard.añadirHabilidad(garraDragon);
        Habilidad respiro = new HabilidadEstadistica("Respiro", 5, true, (int)(charizard.getVidaMaxima()/2), new ModificacionVida());
        charizard.añadirHabilidad(respiro);
        this.mochilaJugador1.put(charizard.getNombre(), charizard);


        Pokemon pikachu = new Pokemon("Pikachu", 50, "Electrico", "Las bolsas de las mejillas están llenas de electricidad, que libera cuando se siente amenazado.",
        110, 110, 70, 75);
        Habilidad trueno = new HabilidadAtaque("Trueno",Tipo.getTipo("Electrico"),110,10);
        pikachu.añadirHabilidad(trueno);
        Habilidad ondaTrueno = new HabilidadEstado("OndaTrueno", 20, new EstadoParalizado());
        pikachu.añadirHabilidad(ondaTrueno);
        Habilidad colaFerrea = new HabilidadAtaque("ColaFerrea",Tipo.getTipo("Normal"),100,15);
        pikachu.añadirHabilidad(colaFerrea);
        Habilidad agilidad = new HabilidadEstadistica("Agilidad", 30, true, 2, new ModificacionVelocidad());
        pikachu.añadirHabilidad(agilidad);
        this.mochilaJugador1.put(pikachu.getNombre(), pikachu);


        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
        100, 110, 90, 135);
        Habilidad esferaAural = new HabilidadAtaque("EsferaAural",Tipo.getTipo("Lucha"),80,20);
        lucario.añadirHabilidad(esferaAural);
        Habilidad pulsoNoche = new HabilidadAtaque("PulsoNoche",Tipo.getTipo("Normal"),80,15);
        lucario.añadirHabilidad(pulsoNoche);
        Habilidad ecoMetalico = new HabilidadEstadistica("EcoMetalico", 40, false, -2, new ModificacionDefensa());
        lucario.añadirHabilidad(ecoMetalico);
        Habilidad metalaser = new HabilidadAtaque("Metalaser",Tipo.getTipo("Normal"),140,5);
        lucario.añadirHabilidad(metalaser);
        this.mochilaJugador1.put(lucario.getNombre(), lucario);


        Pokemon dusknoir = new Pokemon("Dusknoir", 50, "Fantasma", "La antena de la cabeza captura ondas de radio lejanas que le permiten secuestrar a gente.",
        120, 65, 155	, 120);
        Habilidad bolaSombra = new HabilidadAtaque("BolaSombra",Tipo.getTipo("Fantasma"),80,15);
        dusknoir.añadirHabilidad(bolaSombra);
        Habilidad pazMental = new HabilidadEstadistica("PazMental", 20, true, 2, new ModificacionAtaque());
        dusknoir.añadirHabilidad(pazMental);
        Habilidad pulsoUmbrio = new HabilidadAtaque("PulsoUmbrio",Tipo.getTipo("Normal"),80,15);
        dusknoir.añadirHabilidad(pulsoUmbrio);
        Habilidad terratemblor = new HabilidadAtaque("Terratemblor",Tipo.getTipo("Tierra"),60,20);
        dusknoir.añadirHabilidad(terratemblor);
        this.mochilaJugador1.put(dusknoir.getNombre(), dusknoir);


        Pokemon crobat = new Pokemon("Crobat", 50, "Veneno", "Sus cuatro alas le permiten volar más rápida y sigilosamente. Es un Pokémon nocturno.",
        160, 150, 100, 110);
        Habilidad venenoX = new HabilidadAtaque("VenenoX",Tipo.getTipo("Veneno"),70,20);
        crobat.añadirHabilidad(venenoX);
        Habilidad tijeraX = new HabilidadAtaque("TijeraX",Tipo.getTipo("Bicho"),80,15);
        crobat.añadirHabilidad(tijeraX);
        Habilidad acrobata = new HabilidadAtaque("Acrobata",Tipo.getTipo("Volador"),110,15);
        crobat.añadirHabilidad(acrobata);
        Habilidad toxico = new HabilidadEstado("Toxico", 10, new EstadoEnvenenado());
        crobat.añadirHabilidad(toxico);
        this.mochilaJugador1.put(crobat.getNombre(), crobat);


        Item pocion = new Pocion("Pocion", 4, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 3, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 1, new ModificacionVida());
        Item pocionDefensa = new PocionDefensa("Pocion de Defensa", 2, new ModificacionDefensa());
        Item pocionAtaque = new PocionAtaque("Pocion de Ataque", 1, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionEstadoInhabilitado());
        Item curarTodo = new PocionCuracionEstados("Curar todo",1);

        this.itemsJugador1.put(pocion.getNombre(), pocion);
        this.itemsJugador1.put(megaPocion.getNombre(), megaPocion);
        this.itemsJugador1.put(hiperPocion.getNombre(), hiperPocion);
        this.itemsJugador1.put(revivir.getNombre(), revivir);
        this.itemsJugador1.put(pocionDefensa.getNombre(), pocionDefensa);
        this.itemsJugador1.put(pocionAtaque.getNombre(), pocionAtaque);
        this.itemsJugador1.put(curarTodo.getNombre(), curarTodo);
    }



    private void InicialzarPokemonesJugador2(){

        Pokemon alakazam = new Pokemon("Alakazam", 50, "Psiquico", "Se dice que tiene un coeficiente intelectual de unos 5.000.",
        100	, 140, 65, 155);
        Habilidad psiquico = new HabilidadAtaque("Psiquico",Tipo.getTipo("Psiquico"),90,10);
        alakazam.añadirHabilidad(psiquico);
        Habilidad recuperacion = new HabilidadEstadistica("Recuperacion", 5, true, (int)(alakazam.getVidaMaxima()/2), new ModificacionVida());
        alakazam.añadirHabilidad(recuperacion);
        Habilidad energibola = new HabilidadAtaque("Energibola",Tipo.getTipo("Planta"),90,10);
        alakazam.añadirHabilidad(energibola);
        Habilidad maquinacion = new HabilidadEstadistica("Maquinacion", 20, true, 2, new ModificacionAtaque());
        alakazam.añadirHabilidad(maquinacion);
        this.mochilaJugador2.put(alakazam.getNombre(), alakazam);


        Pokemon trevenant = new Pokemon("Trevenant", 50, "Planta", "Se dice que los árboles donde vive Trevenant están poseídos por los espíritus de los muertos.",
        100, 76, 102, 130);
        Habilidad mazazo = new HabilidadAtaque("Mazazo",Tipo.getTipo("Planta"),120,15);
        trevenant.añadirHabilidad(mazazo);
        Habilidad sombraVil = new HabilidadAtaque("SombraVil",Tipo.getTipo("Fantasma"),80,15);
        trevenant.añadirHabilidad(sombraVil);
        Habilidad hypnosis = new HabilidadEstado("Hypnosis", 5, new EstadoDormido());
        trevenant.añadirHabilidad(hypnosis);
        Habilidad caraSusto = new HabilidadEstado("CaraSusto", 5, new EstadoParalizado());
        trevenant.añadirHabilidad(caraSusto);
        this.mochilaJugador2.put(trevenant.getNombre(), trevenant);


        Pokemon golem = new Pokemon("Golem", 50, "Roca", "Es capaz de explotar a voluntad. Utiliza el impulso de la explosión para saltar de una montaña a otra.",
        100, 65, 150, 140);
        Habilidad terremoto = new HabilidadAtaque("Terremoto",Tipo.getTipo("Tierra"),100,10);
        golem.añadirHabilidad(terremoto);
        Habilidad rocaAfilada = new HabilidadAtaque("RocaAfilada",Tipo.getTipo("Roca"),100,5);
        golem.añadirHabilidad(rocaAfilada);
        Habilidad punioTrueno = new HabilidadAtaque("PuñoTrueno",Tipo.getTipo("Electrico"),75,15);
        golem.añadirHabilidad(punioTrueno);
        Habilidad defensaFerrea = new HabilidadEstadistica("DefensaFerrea", 15, true, 2, new ModificacionDefensa());
        golem.añadirHabilidad(defensaFerrea);
        this.mochilaJugador2.put(golem.getNombre(), golem);


        Pokemon rayquaza = new Pokemon("Rayquaza", 50, "Dragon", "Se dice que vive en la capa de ozono. Los anillos que tiene en el cuerpo brillan de siete colores distintos.",
        100, 115, 90, 170);
        Habilidad ascensoDraco = new HabilidadAtaque("AscensoDraco",Tipo.getTipo("Dragon"),120,5);
        rayquaza.añadirHabilidad(ascensoDraco);
        Habilidad poderPasado = new HabilidadAtaque("PoderPasado",Tipo.getTipo("Roca"),60,5);
        rayquaza.añadirHabilidad(poderPasado);
        Habilidad triturar = new HabilidadAtaque("Triturar",Tipo.getTipo("Normal"),80,15);
        rayquaza.añadirHabilidad(triturar);
        Habilidad danzaDragon = new HabilidadEstadistica("DanzaDragon", 20, true, 2, new ModificacionAtaque());
        rayquaza.añadirHabilidad(danzaDragon);
        this.mochilaJugador2.put(rayquaza.getNombre(), rayquaza);


        Pokemon araquanid = new Pokemon("Araquanid", 50, "Bicho", "Araquanid es capaz de expulsar un hilo de agua a gran presión y velocidad gracias a la fuerza de sus patas traseras.",
        100, 62, 152, 90);
        Habilidad hidrobomba = new HabilidadAtaque("Hidrobomba",Tipo.getTipo("Agua"),110,5);
        araquanid.añadirHabilidad(hidrobomba);
        Habilidad toxico = new HabilidadEstado("Toxico", 5, new EstadoEnvenenado());
        araquanid.añadirHabilidad(toxico);
        Habilidad picadura = new HabilidadAtaque("Picadura",Tipo.getTipo("Bicho"),70,20);
        araquanid.añadirHabilidad(picadura);
        Habilidad ventisca = new HabilidadAtaque("Ventisca",Tipo.getTipo("Hielo"),110,5);
        araquanid.añadirHabilidad(ventisca);
        this.mochilaJugador2.put(araquanid.getNombre(), araquanid);


        Pokemon bidoof = new Pokemon("Bidoof", 50, "Normal", "El Pokemon más fuerte de todos los tiempos.",
        100, 5, 60, 6);
                Habilidad placaje = new HabilidadAtaque("Placaje",Tipo.getTipo("Normal"),40,35);
        bidoof.añadirHabilidad(placaje);
        Habilidad mordisco = new HabilidadAtaque("Mordisco",Tipo.getTipo("Normal"),60,25);
        bidoof.añadirHabilidad(mordisco);
        Habilidad ronquido = new HabilidadEstado("Ronquido", 5, new EstadoDormido());
        bidoof.añadirHabilidad(ronquido);
        Habilidad ultimoRecurso = new HabilidadAtaque("UltimoRecurso",Tipo.getTipo("Normal"),999,1);
        bidoof.añadirHabilidad(ultimoRecurso);
        this.mochilaJugador2.put(bidoof.getNombre(), bidoof);


        Item pocion = new Pocion("Pocion", 50, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 2, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 4, new ModificacionVida());
        Item pocionDefensa = new PocionDefensa("Pocion de Defensa", 3, new ModificacionDefensa());
        Item pocionAtaque = new PocionAtaque("Pocion de Ataque", 2, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionEstadoInhabilitado());
        Item curarTodo = new PocionCuracionEstados("Curar todo",1);

        this.itemsJugador2.put(pocion.getNombre(), pocion);
        this.itemsJugador2.put(megaPocion.getNombre(), megaPocion);
        this.itemsJugador2.put(hiperPocion.getNombre(), hiperPocion);
        this.itemsJugador2.put(revivir.getNombre(), revivir);
        this.itemsJugador2.put(pocionDefensa.getNombre(), pocionDefensa);
        this.itemsJugador2.put(pocionAtaque.getNombre(), pocionAtaque);
        this.itemsJugador1.put(curarTodo.getNombre(), curarTodo);
    }


    public Map<String, Item> getItemsJugador1() {
        return this.itemsJugador1;
    }

    public Map<String, Item> getItemsJugador2() {
        return this.itemsJugador2;
    }

    public Map<String, Pokemon> getMochilaJugador1() {
        return this.mochilaJugador1;
    }

    public Map<String, Pokemon> getMochilaJugador2() {
        return this.mochilaJugador2;
    }
}
