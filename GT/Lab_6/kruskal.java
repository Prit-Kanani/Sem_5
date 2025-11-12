package Lab_6;

import java.util.Arrays;

public class kruskal {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 6 },
                { 0, 2, 5 },
                { 0, 3, 10 },
                { 2, 3, 6 },
                { 2, 4, 4 }
        };
        Arrays.sort(graph, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[5];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[][] mst = new int[graph.length][3];
        int mstIndex = 0;
        int sum = 0;

        for (int i = 0; i < graph.length; i++) {
            int U = find(parent, graph[i][0]);
            int V = find(parent, graph[i][1]);

            if (U != V) {
                mst[mstIndex++] = graph[i];
                parent[U] = V;
                sum += graph[i][2];
            }
        }
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 0; i < mstIndex; i++) {
            System.out.println(mst[i][0] + " - " + mst[i][1] + " : " + mst[i][2]);
        }
        System.out.println("Total weight of the Minimum Spanning Tree: " + sum);
    

    }

    private static int find(int[] parent, int u) {
        if (parent[u] == u) {
            return u;
        }
        return find(parent, parent[u]);
    }
}