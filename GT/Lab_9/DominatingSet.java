package Lab_9;

public class DominatingSet {
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},
            {0, 2},
            {2, 3},
            {1, 3}
        };

        int n = 4; // number of vertices
        int[][] graph = new int[n][n];

        // Build adjacency matrix
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.println("All possible dominating sets:");

        int totalSubsets = (int)Math.pow(2, n); // 2^n subsets

        // This loop generates all subsets using a binary idea, no bitwise ops
        for (int subset = 1; subset < totalSubsets; subset++) {
            // Create a selection array
            boolean[] selected = new boolean[n];
            int temp = subset;

            // Fill selection array based on binary digits
            for (int i = 0; i < n; i++) {
                if (temp % 2 == 1) {
                    selected[i] = true;
                }
                temp = temp / 2;
            }

            // Mark all covered vertices
            boolean[] covered = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    covered[i] = true;
                    for (int j = 0; j < n; j++) {
                        if (graph[i][j] == 1) {
                            covered[j] = true;
                        }
                    }
                }
            }

            // Check if all nodes are covered
            boolean isDom = true;
            for (int i = 0; i < n; i++) {
                if (!covered[i]) {
                    isDom = false;
                    break;
                }
            }

            // Print dominating set
            if (isDom) {
                System.out.print("{ ");
                for (int i = 0; i < n; i++) {
                    if (selected[i]) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println("}");
            }
        }
    }
}
