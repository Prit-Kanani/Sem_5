package Lab_2;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. vertex : ");
        int v = sc.nextInt();


        int[][] arr = new int[v][v];
        while (true) {
            System.out.print("Enter the vertex  x : ");
            int x = sc.nextInt();

            System.out.print("Enter the vertex  y : ");
            int y = sc.nextInt();

            System.out.println();

            if (x < 0 || y < 0) {
                break;
            }
            arr[x][y] = 1; 
            arr[y][x] = 1; 
        }

        System.out.print("Enter starting vertex for BFS: ");
        int top = sc.nextInt();

        Stack<Integer> s = new Stack<Integer>();
        
        boolean[] arr2 = new boolean[v];

        s.push(top);
        arr2[top] = true;
        while (!s.isEmpty()) {
            top = s.pop();
            System.err.println(top);
            for (int i = 0; i < v; i++) {
                if (arr[top][i] == 1 && arr2[i] == false) {
                    s.push(i);
                    arr2[i] = true;
                }
            }
        }
        sc.close();

    }
}
