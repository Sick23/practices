package TickTackToe;
import java.util.Scanner;

public class TickTackToe {
    static Scanner teclado = new Scanner(System.in);
 
    public static void main(String[] args) {
        jugar();
    }

    public static void jugar() {
 

        char J1 = 'X';
        char J2 = 'O';
        char vacio = '-';

        boolean turno = true;

        char tablero[][] = new char[3][3];

        rellenarMatriz(tablero, vacio);
 
        int fila, columna;
        boolean posValida, correcto;
 

        while (!finPartida(tablero, vacio)) {
 
            do {
 

                mostrarTurnoActual(turno);
 
                mostrarMatriz(tablero);
 
                correcto = false;
                fila = pedirInteger("Dame la fila");
                columna = pedirInteger("Dame la columna");
 

                posValida = validarPosicion(tablero, fila, columna);
 

                if (posValida) {
 

                    if (!hayValorPosicion(tablero, fila, columna, vacio)) {
                        correcto = true;
                    } else {
                        System.out.println("Ya hay una marca en esa posicion");
                    }
                } else {
                    System.out.println("La posicion no es valida");
                }
 

            } while (!correcto);
 

            if (turno) {
                insertarEn(tablero, fila, columna, J1);
            } else {
                insertarEn(tablero, fila, columna, J2);
            }

            turno = !turno;
        }
 

        mostrarMatriz(tablero);
 
        mostrarGanador(tablero, J1, J2, vacio);
 
    }
 
    public static void mostrarGanador(char[][] matriz, char J1, char J2, char simDef) {
 
        char simbolo = coincidenciaLinea(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, J1, J2, 1);
 
            return;
 
        }
 
        simbolo = coincidenciaColumna(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, J1, J2, 2);
 
            return;
 
        }
 
        simbolo = coincidenciaDiagonal(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, J1, J2, 3);
 
            return;
 
        }
 
        System.out.println("Hay empate");
 
    }

    public static void ganador(char simbolo, char J1, char J2, int tipo) {
 
        switch (tipo) {
            case 1:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por linea");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por linea");
                }
 
                break;
            case 2:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por columna");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por columna");
                }
                break;
            case 3:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por diagonal");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por diagonal");
                }
                break;
        }
 
    }
 


    public static void insertarEn(char[][] matriz, int fila, int columna, char simbolo) {
        matriz[fila][columna] = simbolo;
    }

    public static void mostrarTurnoActual(boolean turno) {
 
        if (turno) {
            System.out.println("Le toca al jugador 1");
        } else {
            System.out.println("Le toca al jugador 2");
        }
 
    }
 

    public static int pedirInteger(String mensaje) {
 
        System.out.println(mensaje);
        int numero = teclado.nextInt();
 
        return numero;
 
    }

    public static void rellenarMatriz(char[][] matriz, char simbolo) {
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) { matriz[i][j] = simbolo; } } } /** * Validamos la posicion que nos insertan * * @param tablero * @param fila * @param columna * @return */ public static boolean validarPosicion(char[][] tablero, int fila, int columna) { if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
            return true;
        }
        return false;
 
    }
 
    public static boolean hayValorPosicion(char[][] matriz, int fila, int columna, char simboloDef) {
        if (matriz[fila][columna] != simboloDef) {
            return true;
        }
 
        return false;
    }

    public static void mostrarMatriz(char[][] matriz) {
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
 
    }

    public static boolean matrizLlena(char[][] matriz, char simboloDef) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == simboloDef) {
                    return false;
                }
            }
        }
 
        return true;
 
    }

    public static boolean finPartida(char[][] matriz, char simboloDef) {
 
        if (matrizLlena(matriz, simboloDef)
                || coincidenciaLinea(matriz, simboloDef) != simboloDef
                || coincidenciaColumna(matriz, simboloDef) != simboloDef
                || coincidenciaDiagonal(matriz, simboloDef) != simboloDef) {
            return true;
        }
 
        return false;
    }

    public static char coincidenciaLinea(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia;
 
        for (int i = 0; i < matriz.length; i++) {
 

            coincidencia = true;

            simbolo = matriz[i][0];
            if (simbolo != simboloDef) {
                for (int j = 1; j < matriz[0].length; j++) {

                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }

                if (coincidencia) {
                    return simbolo;
                }
 
            }
 
        }
 

        return simboloDef;
 
    }
 
    public static char coincidenciaColumna(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia;
 
        for (int j = 0; j < matriz.length; j++) {
 

            coincidencia = true;

            simbolo = matriz[0][j];
            if (simbolo != simboloDef) {
                for (int i = 1; i < matriz[0].length; i++) {

                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }

                if (coincidencia) {
                    return simbolo;
                }
 
            }
 
        }
 

        return simboloDef;
 
    }
 
    public static char coincidenciaDiagonal(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia = true;

        simbolo = matriz[0][0];
        if (simbolo != simboloDef) {
            for (int i = 1; i < matriz.length; i++) {
               
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
 
            if (coincidencia) {
                return simbolo;
            }
 
        }
        simbolo = matriz[0][2];
        if (simbolo != simboloDef) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
              
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        return simboloDef;
 
    }
 
}