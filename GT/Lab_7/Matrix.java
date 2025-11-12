import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = 5;
        int[][] matrix = {
                { 1, 2 },
                { 2, 3 },
                { 4, 3 }
        };

        int[][] graph = new int[rows][rows];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                graph[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            graph[matrix[i][0] - 1][matrix[i][1] - 1] = 1;
            graph[matrix[i][1] - 1][matrix[i][0] - 1] = 1;
        }
        

        printMatrix(graph);

        for (int i = 0; i < graph.length; i++) {
            boolean flage = false;
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    flage = true;
                    break;
                }
            }
            if (!flage) {
                System.out.println("The Isoleted vertex is : " + (++i));
            }
        }
        sc.close();
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
