import java.util.Random;

public class matrices_Random {
    public static void main(String[] args) {
        
        int[][] matriz = new int[3][3];
        Random rand = new Random();


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(100);
            }
        }

        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("+----+----+----+");

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("| " + String.format("%2d", matriz[i][j]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("+----+----+----+");

    }
}
