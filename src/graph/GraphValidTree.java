package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited =  new boolean[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int[] edge : edges) {
            if (adjList[edge[0]] == null) {
                adjList[edge[0]] = new ArrayList<>();
            }
            if (adjList[edge[1]] == null) {
                adjList[edge[1]] = new ArrayList<>();
            }
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        if (!dfs(adjList, visited, -1, 0)) {
            return false;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] adjList, boolean[] visited, int last, int cur) {
        visited[cur] = true;
        if (adjList[cur] == null || adjList[cur].size() == 0) {
            return true;
        }
        for (int next : adjList[cur]) {
            if (next == last) {
                continue;
            }
            if (visited[next]) {
                return false;
            }
            dfs(adjList, visited, cur, next);
        }
        return true;
    }
}
