package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, heights[0].length - 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, heights.length - 1, j);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int[][] helper, int i, int j) {
        if (helper[i][j] == 1) {
            return;
        }
        helper[i][j] = 1;
        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (i_ >= 0 && i_ < heights.length && j_ >= 0 && j_ < heights[0].length) {
                if (heights[i][j] <= heights[i_][j_]) {
                    dfs(heights, helper, i_, j_);
                }
            }
        }
    }
}
