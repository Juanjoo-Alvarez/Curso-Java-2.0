public class matrices {
    
    public static void main(String[] args) {
        
        int [][] matriz = {
            {1, 2, 3},
            {4,  5, 6}
        };

        System.out.println("Elemento en la posicion [1,1]: " + matriz[1][1]);


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}