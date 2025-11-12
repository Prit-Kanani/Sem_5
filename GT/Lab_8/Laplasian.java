package Lab_8;

public class Laplasian {
    public static void main(String[] args) {

        int[][] arr = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };

        int n = arr.length;
        int[][] lap = new int[n][n];

        // Construct Laplacian matrix
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += arr[i][j];
                lap[i][j] = -arr[i][j];  // Negate adjacency
            }
            lap[i][i] = degree; // Degree on diagonal
        }

        // Print Laplacian matrix
        System.out.println("Laplacian Matrix:");
        System.out.println("------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", lap[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("------------------------------");
    }
}
