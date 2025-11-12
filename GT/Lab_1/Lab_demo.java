import java.util.Scanner;

public class Lab_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // this is max min
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the element in array[" + i + "] : ");
            array[i] = sc.nextInt();
        }
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < 3; i++) {
            System.err.println(array[i]);
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        
        //this is 2d array
        System.out.println("The max no. is = " + max + " and the min no. is = " + min);
        int a1[][] = { { 1, 2 }, { 3, 4 } };

        int[][] a2 = { { 5, 6 }, { 7, 8 } };

        int[][] a3 = new int[2][2];

        //this is addtion
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a3[i][j] = a1[i][j] + a2[i][j];
            }
        }

        // this is transpose
        for(int i = 0;i<2;i++){
            for(int j = 0;j>i;j++){
                int temp = a1[i][j];
                a1[i][j] = a1[j] [i];
                a1[j][i] = temp;
            }
        }

        //this is multiplication
        for (int i = 0;i<2;i++){
            for (int j = 0; j<2;j++){
                for (int k = 0;k<2;k++){
                    a3[i][j] += a1[i][k] * a2[k][j];
                }
            }
        }

        sc.close();
    }
}