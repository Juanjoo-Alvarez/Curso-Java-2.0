import java.util.Scanner;

public class Contecta4 {
    public static void main(String[] args) {
        
        final int FILAS = 6;
        final int COLUMNAS = 7;
        char[][] tablero = new char[FILAS][COLUMNAS];
        inicializarTablero(tablero);

        boolean jugador1 = true;
        boolean juegoTerminado = false;

        Scanner scanner = new Scanner(System.in);

        while (!juegoTerminado) { 
            imprimirTablero(tablero);
            int columna = obtenerMovimiento(scanner, jugador1 ? 'X' : 'O');
            if (columna == -1) {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
                continue;
            }

            boolean movimientoExitoso = hacerMovimiento(tablero, columna, jugador1 ? 'X' : 'O');
            if (!movimientoExitoso) {
                System.out.println("Columna llena. Inténtalo de nuevo.");
                continue;
            }

            juegoTerminado = verificarVictoria(tablero, jugador1 ? 'X' : 'O');

            if (juegoTerminado) {
                imprimirTablero(tablero);
                System.out.println("¡Jugador " + (jugador1 ? "1" : "2") + " gana!");
            } else if (esEmpate(tablero)) {
                imprimirTablero(tablero);
                System.out.println("¡Empate!");
                juegoTerminado = true;
            } else {
                jugador1 = !jugador1;
            }
        }

        scanner.close();
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '.';
            }
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    public static int obtenerMovimiento(Scanner scanner, char jugador) {
        System.out.print("Jugador " + jugador + ", elige una columna (1-7): ");
        int columna = scanner.nextInt() - 1;
        if (columna < 0 || columna >= 7) {
            return -1;
        }
        return columna;
    }

    public static boolean hacerMovimiento(char[][] tablero, int columna, char jugador) {
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (tablero[i][columna] == '.') {
                tablero[i][columna] = jugador;
                return true;
            }
        }
        return false;
    }

    public static boolean verificarVictoria(char[][] tablero, char jugador) {
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length - 3; j++) {
                if (tablero[i][j] == jugador && tablero[i][j + 1] == jugador &&
                    tablero[i][j + 2] == jugador && tablero[i][j + 3] == jugador) {
                    return true;
                }
            }
        }

        
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j] == jugador &&
                    tablero[i + 2][j] == jugador && tablero[i + 3][j] == jugador) {
                    return true;
                }
            }
        }

        
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < tablero[i].length - 3; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j + 1] == jugador &&
                    tablero[i + 2][j + 2] == jugador && tablero[i + 3][j + 3] == jugador) {
                    return true;
                }
            }
        }

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length - 3; j++) {
                if (tablero[i][j] == jugador && tablero[i - 1][j + 1] == jugador &&
                    tablero[i - 2][j + 2] == jugador && tablero[i - 3][j + 3] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < tablero[0].length; i++){
            if (tablero[0][i] == '.'){
                return false;
            }
        }
        return true;
    }
    
}
