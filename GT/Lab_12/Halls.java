import java.util.*;

public class Halls {
    public static boolean checkHallsTheorem(int[][] graph, int n, int m) {
        // n: number of vertices in left set (U)
        // m: number of vertices in right set (V)
        // graph[i][j] == 1 if edge exists between U[i] and V[j]
        // For all subsets S of U, |N(S)| >= |S|
        // We'll check for all subsets of U

        for (int mask = 1; mask < (1 << n); mask++) {
            Set<Integer> neighbors = new HashSet<>();
            int countS = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    countS++;
                    for (int j = 0; j < m; j++) {
                        if (graph[i][j] == 1) {
                            neighbors.add(j);
                        }
                    }
                }
            }
            if (neighbors.size() < countS) {
                // Show the violating subset
                System.out.print("Hall's theorem fails for subset S = { ");
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        System.out.print("U" + i + " ");
                    }
                }
                System.out.print("}, N(S) = { ");
                for (int v : neighbors) {
                    System.out.print("V" + v + " ");
                }
                System.out.println("}");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example bipartite graph
        // U = {U0, U1, U2}
        // V = {V0, V1, V2}
        // Edges: U0-V0, U1-V1, U2-V1
        int n = 3, m = 3;
        int[][] graph = {
            {1, 0, 0}, // U0 connected to V0
            {0, 1, 0}, // U1 connected to V1
            {0, 1, 0}  // U2 connected to V1
        };

        boolean halls = checkHallsTheorem(graph, n, m);
        if (halls) {
            System.out.println("The bipartite graph satisfies Hall's theorem.");
        } else {
            System.out.println("The bipartite graph does NOT satisfy Hall's theorem.");
        }
    }
}