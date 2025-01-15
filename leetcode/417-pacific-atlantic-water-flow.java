import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> Pset = new HashSet<>();
        Set<String> Aset = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, Pset, i, 0);
            dfs(heights, Aset, i, heights[0].length - 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights, Pset, 0, j);
            dfs(heights, Aset, heights.length - 1, j);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (Pset.contains(i + " " + j) && Aset.contains(i + " " + j)) {
                    List<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    ans.add(position);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, Set<String> visitSet, int i, int j) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visitSet.contains(i + " " + j))
            return;

        visitSet.add(i + " " + j);
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] del : dir) {
            int newRow = i + del[0];
            int newCol = j + del[1];
            if ((newRow >= 0) && (newRow < heights.length) && (newCol >= 0) && (newCol < heights[0].length)
                    && (heights[newRow][newCol] >= heights[i][j])) {
                dfs(heights, visitSet, i + del[0], j + del[1]);
            }
        }

    }
}