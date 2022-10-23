package graph;

public class NumberOfIslands {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (isValid(grid, i_, j_)) {
                dfs(grid, i_, j_);
            }
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        return grid[i][j] == '1';
    }
}
