package org.fiuba.algoritmos3;

public class Constantes {
    public static final String OPCION_UNO = "1";
    public static final String OPCION_DOS = "2";

    public static final String OPCION_TRES = "3";
    public static final String OPCION_CUATRO = "4";
    public static final String OPCION_CINCO = "5";

    public static final int LIMITE_CARACTERES = 50;
    public static final double PORCENTAJE = 0.1;

    public static final double PORCENTAJE_VENENO = 0.05;
    public static final String ESTADO_NORMAL = "Normal";
    public static final String ESTADO_INHABILITADO = "Inhabilitado";
    public static final String ESTADO_PARALIZADO = "Paralizado";
    public static final String ESTADO_DORMIDO = "Dormido";
    public static final String ESTADO_ENVENENADO = "Envenenado";

    public static final String TIPO_AGUA = "Agua";
    public static final String TIPO_BICHO = "Bicho";
    public static final String TIPO_DRAGON = "Dragon";
    public static final String TIPO_ELECTRICO = "Electrico";
    public static final String TIPO_FANTASMA = "Fantasma";
    public static final String TIPO_FUEGO = "Fuego";
    public static final String TIPO_HIELO = "Hielo";
    public static final String TIPO_LUCHA = "Lucha";
    public static final String TIPO_NORMAL = "Normal";
    public static final String TIPO_PLANTA = "Planta";
    public static final String TIPO_PSIQUICO = "Psiquico";
    public static final String TIPO_ROCA = "Roca";
    public static final String TIPO_TIERRA = "Tierra";
    public static final String TIPO_VENENO = "Veneno";
    public static final String TIPO_VOLADOR = "Volador";

    public static final String RELACION_FUERTE = "Fuerte";
    public static final String RELACION_NORMAL = "Normal";

    public static final String RELACION_DEBIL = "Debil";
    public static final String RELACION_NULA = "Nula";
    public static final double MULTIPLICADOR_FUERTE = 2;
    public static final double MULTIPLICADOR_DEBIL = 0.5;
    public static final double MULTIPLICADOR_NULA = 0;
    public static final double MULTIPLICADOR_NEUTRAL = 1;
    public static final double BONUS_MISMO_TIPO = 1.5;
    public static final double BONUS_NEUTRAL = 1;
    public static final int PROBABILIDAD_CRITICO = 90;
    public static final double CRITICO = 2.0;
    public static final double NO_CRITICO = 1.0;


    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }




}
