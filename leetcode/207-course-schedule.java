import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(course).add(prerequisiteCourse);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] currentPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, visited, currentPath))
                return false;
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adjList, boolean[] visited, boolean[] currentPath) {
        if (currentPath[course])
            return false;

        if (visited[course])
            return true;
        visited[course] = true;

        currentPath[course] = true;
        for (int crs : adjList.get(course)) {
            if (!dfs(crs, adjList, visited, currentPath))
                return false;
        }
        currentPath[course] = false;
        return true;
    }
}