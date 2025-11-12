package Lab_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class vm {
    public static void main(String[] args) {

        // Get user input for CPU and Memory usage
        int[][] vm = new int[3][2];

        for (int i = 0; i < 3; i++) {
            vm[i][0] = (int) (Math.random() * 15);
            vm[i][1] = (int) (Math.random() * 15);
            while (vm[i][0] == 0 || vm[i][1] == 0) {
                vm[i][0] = (int) (Math.random() * 10);
                vm[i][1] = (int) (Math.random() * 10);
            }
        }

        System.out.println();
        System.out.println("The VM : ");

        // Print VM CPU and Memory usage
        for (int i = 0; i < 3; i++) {
            System.out.println("VM " + (i + 1) + ": " + vm[i][0] + " | " + vm[i][1]);
        }

        // Get user input for Task CPU and Memory usage
        int[][] task = new int[3][2];

        for (int i = 0; i < 3; i++) {
            task[i][0] = (int) (Math.random() * 5);
            task[i][1] = (int) (Math.random() * 5);
            while (task[i][0] == 0 || task[i][1] == 0) {
                task[i][0] = (int) (Math.random() * 10);
                task[i][1] = (int) (Math.random() * 10);
            }
        }
        System.out.println();
        System.out.println("The Task : ");
        // Print Task CPU and Memory usage
        for (int i = 0; i < 3; i++) {
            System.out.println("Task " + (i + 1) + " : " + task[i][0] + " | " + task[i][1]);
        }

        // Calculate cost of each task in each VM
        int[][] cost = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = (int) (Math.random() * 10);
                while (cost[i][j] == 0) {
                    cost[i][j] = (int) (Math.random() * 10);
                }
            }
        }
        System.out.println();
        System.out.println("The cost : ");
        // Print cost of each task in each VM
        for (int i = 0; i < 3; i++) {
            System.out.println(cost[i][0] + " | " + cost[i][1] + " | " + cost[i][2]);
        }

        System.out.println();
        System.out.println("The Answer : ");
        // usage by each task
        for (int i = 0; i < 3; i++) {
            int minCost = Integer.MAX_VALUE;
            int efficientVM = -1;
            boolean flag = false;
            Set<Integer> index = new HashSet<>(Arrays.asList(0, 1, 2));

            while (!flag || index.isEmpty()) {
                minCost = Integer.MAX_VALUE;
                efficientVM = -1;
                for (int j : index) {
                    if (cost[j][i] < minCost) {
                        minCost = cost[j][i];
                        efficientVM = j;
                    }
                }
                if (vm[efficientVM][0] >= task[i][0] && vm[efficientVM][1] >= task[i][1]) {
                    vm[efficientVM][0] -= task[i][0];
                    vm[efficientVM][1] -= task[i][1];
                    flag = true;
                } else {
                    index.remove(efficientVM);
                }
            }
            if (!flag) {
                System.out.println("Task " + (i + 1) + ": No any VM available");
            } else {
                System.out.println("Task " + (i + 1) + ": VM " + (efficientVM + 1) + " with cost " + minCost);
            }
        }
    }
}
