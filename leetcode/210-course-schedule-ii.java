import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> ans = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                return new int[0];
        }
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
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
        ans.add(course);
        return true;
    }
}