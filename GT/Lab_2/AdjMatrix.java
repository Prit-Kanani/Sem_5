package Lab_2;

import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no. vertex : ");
        int v = sc.nextInt();

        int pl = v * (v - 1) / 2;
        int[][] arr = new int[pl][2];
        for (int i = 0; i < pl; i++) {
            int x = 0;
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter the vertex " + i + "," + j + " : ");
                x = sc.nextInt();
                if (x < 0) {
                    break;
                }
                arr[i][j] = x;
            }
            if (x < 0) {
                break;
            }
            System.err.println(" ");
        }
        int[][] arr2 = new int[v][v];
        for (int i = 0; i < pl; i++) {
            if (arr[i] != null && arr[i][0] != arr[i][1]) {
                arr2[arr[i][0]][arr[i][1]] = 1;
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < v; j++) {
                if (arr2[i][j] == 1) {
                    System.out.print(j + ",");
                }
            }
            System.out.println(" ");
        }
        for (int i = 0; i < v; i++) {
            int in = 0;
            int out = 0;
            System.out.print(i + " -> ");
            for (int j = 0; j < v; j++) {
                if (arr2[j][i] == 1) {
                    in++;
                }
                if (arr2[i][j] == 1) {
                    out++;
                }
            }
            System.err.print("in degree is : " + in + " , and out degree is : " + out);
            System.out.println(" ");
        }

        sc.close();
    }
}
