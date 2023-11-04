package org.fiuba.algoritmos3;

import Estados.EstadoConfuso;
import Estados.EstadoDormido;
import Estados.EstadoEnvenenado;
import Estados.EstadoParalizado;
import Item.*;
import Modificaciones.*;
import Pokemones.*;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

import static org.fiuba.algoritmos3.Constantes.*;

public class Datos {

    //Atributos:
    private final Map<String, Pokemon> mochilaJugador1;
    private final Map<String, Pokemon> mochilaJugador2;
    private final Map<String, Item> itemsJugador1;
    private final Map<String, Item> itemsJugador2;

    //Metodos:

    public Datos() {

        this.mochilaJugador1 = new HashMap<>();
        this.mochilaJugador2 = new HashMap<>();
        this.itemsJugador1 = new HashMap<>();
        this.itemsJugador2 = new HashMap<>();

        this.InicialzarPokemonesJugador1();
        this.InicialzarPokemonesJugador2();
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

    private void InicialzarPokemonesJugador1(){

        Pokemon squirtle = new Pokemon("Squirtle", 50, "Agua", "El caparazón de Squirtle no sólo lo protege; su forma redondeada y sus hendiduras reducen su resistencia al agua y le permiten nadar más rápido.",
        119, 63, 85, 70);
        Habilidad chorroDeAgua = new HabilidadAtaque("ChorroDeAgua",Tipo.instanciarUnTipoDe("Agua"),40,25);
        squirtle.aniadirHabilidad(chorroDeAgua);
        Habilidad cabezazo = new HabilidadAtaque("Cabezazo",Tipo.instanciarUnTipoDe("Normal"),130,10);
        squirtle.aniadirHabilidad(cabezazo);
        Habilidad defensaFerrea = new HabilidadEstadistica("DefensaFerrea", 15, true, 2, new ModificacionDefensa());
        squirtle.aniadirHabilidad(defensaFerrea);
        Habilidad danzaDeLluvia = new HabilidadClima("DanzaDeLluvia", CLIMA_LLUVIA, 5);
        squirtle.aniadirHabilidad(danzaDeLluvia);
        this.mochilaJugador1.put(squirtle.getNombre(), squirtle);


        Pokemon charizard = new Pokemon("Charizard", 50, "Fuego", "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido.",
        153, 120, 105, 129);
        Habilidad tajoAereo = new HabilidadAtaque("TajoAereo",Tipo.instanciarUnTipoDe("Volador"),75,15);
        charizard.aniadirHabilidad(tajoAereo);
        Habilidad lanzallamas = new HabilidadAtaque("Lanzallamas",Tipo.instanciarUnTipoDe("Fuego"),90,15);
        charizard.aniadirHabilidad(lanzallamas);
        Habilidad garraDragon = new HabilidadAtaque("GarraDragon",Tipo.instanciarUnTipoDe("Dragon"),80,15);
        charizard.aniadirHabilidad(garraDragon);
        Habilidad respiro = new HabilidadEstadistica("Respiro", 5, true, (int)(charizard.getVidaMaxima()/2), new ModificacionVida());
        charizard.aniadirHabilidad(respiro);
        this.mochilaJugador1.put(charizard.getNombre(), charizard);


        Pokemon pikachu = new Pokemon("Pikachu", 50, "Electrico", "Las bolsas de las mejillas están llenas de electricidad, que libera cuando se siente amenazado.",
        110, 110, 70, 75);
        Habilidad trueno = new HabilidadAtaque("Trueno",Tipo.instanciarUnTipoDe("Electrico"),110,10);
        pikachu.aniadirHabilidad(trueno);
        Habilidad ondaTrueno = new HabilidadEstado("OndaTrueno", 20, new EstadoParalizado());
        pikachu.aniadirHabilidad(ondaTrueno);
        Habilidad tormentaElectrica = new HabilidadClima("TormentaElectrica", CLIMA_TORMENTA_DE_RAYOS, 5);
        pikachu.aniadirHabilidad(tormentaElectrica);
        Habilidad agilidad = new HabilidadEstadistica("Agilidad", 30, true, 2, new ModificacionVelocidad());
        pikachu.aniadirHabilidad(agilidad);
        this.mochilaJugador1.put(pikachu.getNombre(), pikachu);


        Pokemon lucario = new Pokemon("Lucario", 50, "Lucha", "Puede leer los pensamientos de su adversario a través de su aura.",
        100, 110, 90, 135);
        Habilidad esferaAural = new HabilidadAtaque("EsferaAural",Tipo.instanciarUnTipoDe("Lucha"),80,20);
        lucario.aniadirHabilidad(esferaAural);
        Habilidad pulsoNoche = new HabilidadAtaque("PulsoNoche",Tipo.instanciarUnTipoDe("Normal"),80,15);
        lucario.aniadirHabilidad(pulsoNoche);
        Habilidad ecoMetalico = new HabilidadEstadistica("EcoMetalico", 40, false, -2, new ModificacionDefensa());
        lucario.aniadirHabilidad(ecoMetalico);
        Habilidad metalaser = new HabilidadAtaque("Metalaser",Tipo.instanciarUnTipoDe("Normal"),140,5);
        lucario.aniadirHabilidad(metalaser);
        this.mochilaJugador1.put(lucario.getNombre(), lucario);


        Pokemon dusknoir = new Pokemon("Dusknoir", 50, "Fantasma", "La antena de la cabeza captura ondas de radio lejanas que le permiten secuestrar a gente.",
        120, 65, 155	, 120);
        Habilidad bolaSombra = new HabilidadAtaque("BolaSombra",Tipo.instanciarUnTipoDe("Fantasma"),80,15);
        dusknoir.aniadirHabilidad(bolaSombra);
        Habilidad pazMental = new HabilidadEstadistica("PazMental", 20, true, 2, new ModificacionAtaque());
        dusknoir.aniadirHabilidad(pazMental);
        Habilidad pulsoUmbrio = new HabilidadAtaque("PulsoUmbrio",Tipo.instanciarUnTipoDe("Normal"),80,15);
        dusknoir.aniadirHabilidad(pulsoUmbrio);
        Habilidad terratemblor = new HabilidadAtaque("Terratemblor",Tipo.instanciarUnTipoDe("Tierra"),60,20);
        dusknoir.aniadirHabilidad(terratemblor);
        this.mochilaJugador1.put(dusknoir.getNombre(), dusknoir);


        Pokemon crobat = new Pokemon("Crobat", 50, "Veneno", "Sus cuatro alas le permiten volar más rápida y sigilosamente. Es un Pokémon nocturno.",
        160, 150, 100, 110);
        Habilidad venenoX = new HabilidadAtaque("VenenoX",Tipo.instanciarUnTipoDe("Veneno"),80,15);
        crobat.aniadirHabilidad(venenoX);
        Habilidad tijeraX = new HabilidadAtaque("TijeraX",Tipo.instanciarUnTipoDe("Bicho"),80,15);
        crobat.aniadirHabilidad(tijeraX);
        Habilidad acrobata = new HabilidadAtaque("Acrobata",Tipo.instanciarUnTipoDe("Volador"),110,15);
        crobat.aniadirHabilidad(acrobata);
        Habilidad toxico = new HabilidadEstado("Toxico", 10, new EstadoEnvenenado());
        crobat.aniadirHabilidad(toxico);
        this.mochilaJugador1.put(crobat.getNombre(), crobat);


        Item pocion = new Pocion("Pocion", 4, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 3, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 1, new ModificacionVida());//-->contemplado que solo tenga 1
        Item molestaAlumnos =  new PocionMolestaAlumnos("Molesta Alumnos",4,new ModificacionVida());
        Item pocionDefensa = new DefensaX("Defensa X", 2, new ModificacionDefensa());
        Item pocionAtaque = new AtaqueX("Ataque X", 1, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionEstadoInhabilitado());
        Item curarTodo = new PocionCuracionEstados("CuraTodo",1, new ModificacionEstado());

        this.itemsJugador1.put(pocion.getNombre(), pocion);
        this.itemsJugador1.put(megaPocion.getNombre(), megaPocion);
        this.itemsJugador1.put(hiperPocion.getNombre(), hiperPocion);
        this.itemsJugador1.put(revivir.getNombre(), revivir);
        this.itemsJugador1.put(pocionDefensa.getNombre(), pocionDefensa);
        this.itemsJugador1.put(pocionAtaque.getNombre(), pocionAtaque);
        this.itemsJugador1.put(curarTodo.getNombre(), curarTodo);
        this.itemsJugador1.put(molestaAlumnos.getNombre(), molestaAlumnos); //--->
    }

    private void InicialzarPokemonesJugador2(){

        Pokemon alakazam = new Pokemon("Alakazam", 50, "Psiquico", "Se dice que tiene un coeficiente intelectual de unos 5.000.",
        100	, 140, 65, 155);
        Habilidad psiquico = new HabilidadAtaque("Psiquico",Tipo.instanciarUnTipoDe("Psiquico"),90,10);
        alakazam.aniadirHabilidad(psiquico);
        Habilidad recuperacion = new HabilidadEstadistica("Recuperacion", 5, true, (int)(alakazam.getVidaMaxima()/2), new ModificacionVida());
        alakazam.aniadirHabilidad(recuperacion);
        Habilidad maquinacion = new HabilidadEstadistica("Maquinacion", 20, true, 2, new ModificacionAtaque());
        alakazam.aniadirHabilidad(maquinacion);
        Habilidad confundir = new HabilidadEstado("Confuso",5,new EstadoConfuso());
        alakazam.aniadirHabilidad(confundir);
        this.mochilaJugador2.put(alakazam.getNombre(), alakazam);


        Pokemon trevenant = new Pokemon("Trevenant", 50, "Planta", "Se dice que los árboles donde vive Trevenant están poseídos por los espíritus de los muertos.",
        100, 76, 102, 130);
        Habilidad mazazo = new HabilidadAtaque("Mazazo",Tipo.instanciarUnTipoDe("Planta"),120,15);
        trevenant.aniadirHabilidad(mazazo);
        Habilidad sombraVil = new HabilidadAtaque("SombraVil",Tipo.instanciarUnTipoDe("Fantasma"),80,15);
        trevenant.aniadirHabilidad(sombraVil);
        Habilidad hypnosis = new HabilidadEstado("Hypnosis", 5, new EstadoDormido());
        trevenant.aniadirHabilidad(hypnosis);
        Habilidad caraSusto = new HabilidadEstado("CaraSusto", 5, new EstadoParalizado());
        trevenant.aniadirHabilidad(caraSusto);
        this.mochilaJugador2.put(trevenant.getNombre(), trevenant);


        Pokemon golem = new Pokemon("Golem", 50, "Roca", "Es capaz de explotar a voluntad. Utiliza el impulso de la explosión para saltar de una montaña a otra.",
        100, 65, 150, 140);
        Habilidad terremoto = new HabilidadAtaque("Terremoto",Tipo.instanciarUnTipoDe("Tierra"),100,10);
        golem.aniadirHabilidad(terremoto);
        Habilidad rocaAfilada = new HabilidadAtaque("RocaAfilada",Tipo.instanciarUnTipoDe("Roca"),100,5);
        golem.aniadirHabilidad(rocaAfilada);
        Habilidad tormentaDeArena = new HabilidadClima("TormentaDeArena", CLIMA_TORMENTA_DE_ARENA, 5);
        golem.aniadirHabilidad(tormentaDeArena);
        Habilidad defensaFerrea = new HabilidadEstadistica("DefensaFerrea", 15, true, 2, new ModificacionDefensa());
        golem.aniadirHabilidad(defensaFerrea);
        this.mochilaJugador2.put(golem.getNombre(), golem);


        Pokemon rayquaza = new Pokemon("Rayquaza", 50, "Dragon", "Se dice que vive en la capa de ozono. Los anillos que tiene en el cuerpo brillan de siete colores distintos.",
        100, 115, 90, 170);
        Habilidad ascensoDraco = new HabilidadAtaque("AscensoDraco",Tipo.instanciarUnTipoDe("Dragon"),120,5);
        rayquaza.aniadirHabilidad(ascensoDraco);
        Habilidad poderPasado = new HabilidadAtaque("PoderPasado",Tipo.instanciarUnTipoDe("Roca"),60,5);
        rayquaza.aniadirHabilidad(poderPasado);
        Habilidad triturar = new HabilidadAtaque("Triturar",Tipo.instanciarUnTipoDe("Normal"),80,15);
        rayquaza.aniadirHabilidad(triturar);
        Habilidad danzaDragon = new HabilidadEstadistica("DanzaDragon", 20, true, 2, new ModificacionAtaque());
        rayquaza.aniadirHabilidad(danzaDragon);
        this.mochilaJugador2.put(rayquaza.getNombre(), rayquaza);


        Pokemon araquanid = new Pokemon("Araquanid", 50, "Bicho", "Araquanid es capaz de expulsar un hilo de agua a gran presión y velocidad gracias a la fuerza de sus patas traseras.",
        100, 62, 152, 90);
        Habilidad hidrobomba = new HabilidadAtaque("Hidrobomba",Tipo.instanciarUnTipoDe("Agua"),110,5);
        araquanid.aniadirHabilidad(hidrobomba);
        Habilidad toxico = new HabilidadEstado("Toxico", 5, new EstadoEnvenenado());
        araquanid.aniadirHabilidad(toxico);
        Habilidad picadura = new HabilidadAtaque("Picadura",Tipo.instanciarUnTipoDe("Bicho"),70,20);
        araquanid.aniadirHabilidad(picadura);
        Habilidad ventisca = new HabilidadAtaque("Ventisca",Tipo.instanciarUnTipoDe("Hielo"),110,5);
        araquanid.aniadirHabilidad(ventisca);
        this.mochilaJugador2.put(araquanid.getNombre(), araquanid);


        Pokemon bidoof = new Pokemon("Bidoof", 50, "Normal", "El Pokemon más fuerte de todos los tiempos.",
        100, 5, 60, 6);
                Habilidad placaje = new HabilidadAtaque("Placaje",Tipo.instanciarUnTipoDe("Normal"),40,35);
        bidoof.aniadirHabilidad(placaje);
        Habilidad mordisco = new HabilidadAtaque("Mordisco",Tipo.instanciarUnTipoDe("Normal"),60,25);
        bidoof.aniadirHabilidad(mordisco);
        Habilidad ronquido = new HabilidadEstado("Ronquido", 5, new EstadoDormido());
        bidoof.aniadirHabilidad(ronquido);
        Habilidad ultimoRecurso = new HabilidadAtaque("UltimoRecurso",Tipo.instanciarUnTipoDe("Normal"),999,1);
        bidoof.aniadirHabilidad(ultimoRecurso);
        this.mochilaJugador2.put(bidoof.getNombre(), bidoof);


        Item pocion = new Pocion("Pocion", 50, new ModificacionVida());
        Item megaPocion = new MegaPocion("Mega Pocion", 2, new ModificacionVida());
        Item hiperPocion = new HiperPocion("Hiper Pocion", 1, new ModificacionVida()); //-->contemplado que solo tenga 1
        Item molestaAlumnos =  new PocionMolestaAlumnos("Molesta Alumnos",4,new ModificacionVida());
        Item pocionDefensa = new DefensaX("Defensa X", 3, new ModificacionDefensa());
        Item pocionAtaque = new AtaqueX("Ataque X", 2, new ModificacionAtaque());
        Item revivir = new Revivir("Revivir", 1, new ModificacionEstadoInhabilitado());
        Item curarTodo = new PocionCuracionEstados("CuraTodo",1, new ModificacionEstado());

        this.itemsJugador2.put(pocion.getNombre(), pocion);
        this.itemsJugador2.put(megaPocion.getNombre(), megaPocion);
        this.itemsJugador2.put(hiperPocion.getNombre(), hiperPocion);
        this.itemsJugador2.put(revivir.getNombre(), revivir);
        this.itemsJugador2.put(pocionDefensa.getNombre(), pocionDefensa);
        this.itemsJugador2.put(pocionAtaque.getNombre(), pocionAtaque);
        this.itemsJugador2.put(curarTodo.getNombre(), curarTodo);
        this.itemsJugador2.put(molestaAlumnos.getNombre(), molestaAlumnos); //--->
    }

}
