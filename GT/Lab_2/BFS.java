package Lab_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
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

        Queue<Integer> q = new LinkedList<>();

        boolean[] arr2 = new boolean[v];

        q.add(top);
        arr2[top] = true;

        while (!q.isEmpty()) {
            top = q.poll();
            System.err.println(top);
            for (int i = 0; i < v; i++) {
                if (arr[top][i] == 1 && arr2[i] == false) {
                    q.add(i);
                    arr2[i] = true;
                }
            }
        }
        sc.close();
    }

}
