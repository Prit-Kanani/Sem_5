package Lab_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class cutv {
    public static void main(String[] args) {
        // No. of nodes
        int n = 5;

        // Edge set
        int[][] edge = { { 0, 1 },
                { 0, 2 },
                { 2, 3 },
                { 2, 4 }
        };
        // Build adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // cv[i] = adjacency set after ignoring vertex i
        Set<Integer>[] cv = new HashSet[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> neighbors = new HashSet<>();
            for (int v = 0; v < n; v++) {
                if (v == i) continue; // skip adjacency of ignored vertex
                neighbors.addAll(adj[v]); // only neighbors, not v itself
            }
                cv[i] = neighbors;
        }

        for(int i = 0; i < n ; i++){
            if(cv[i].size() != n){
                System.out.println("The cut-vetex for the graph is  : " + i);
            }
        }

    }
}
