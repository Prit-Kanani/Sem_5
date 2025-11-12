#include <stdio.h>
#define INF 99999   // A large value to represent "no edge"

int g[5][5] = {
    {0, 3, INF, INF, -4},
    {INF, 0, INF, 1, 7},
    {INF, 4, 0, INF, INF},
    {2, INF, -1, 0, INF},
    {INF, INF, INF, 6, 0}
};
void floid(int graph[5][5],int n ){
    for(int i = 0; i < 5 ; ++i){
        for(int j = 0 ; j < 5; ++j){
            if(graph[i][j] > graph[i][n] + graph[n][j]){
                graph[i][j] = graph[i][n] + graph[n][j];
            }
        }
    }
    floyd(graph, n + 1);
}

int main() {
    floyd(g, 0);
}
