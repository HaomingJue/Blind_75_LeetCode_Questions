package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            if (!edgeMap.containsKey(edge[0])) {
                edgeMap.put(edge[0], new ArrayList<>());
            }
            if (!edgeMap.containsKey(edge[1])) {
                edgeMap.put(edge[1], new ArrayList<>());
            }
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(edgeMap, visited, i);
            }
        }
        return ans;
    }

    private void dfs(HashMap<Integer, List<Integer>> edgeMap, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        List<Integer> adjNodes = edgeMap.getOrDefault(i, null);
        if (adjNodes == null) {
            return;
        }
        for (int node : adjNodes) {
            dfs(edgeMap, visited, node);
        }
    }
}
