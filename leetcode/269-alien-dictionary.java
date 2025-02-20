import java.util.*;

class SolutionDFSTopologicalSort {
    public String alienOrder(String[] words) {
        // Step 1: Build adjacency list
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjList.putIfAbsent(ch, new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }

        // Step 2: Compare adjacent words to determine order
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            // Edge case: If "abc" appears before "ab", return ""
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char u = first.charAt(j);
                char v = second.charAt(j);
                if (u != v) {
                    if (!adjList.get(u).contains(v)) {
                        adjList.get(u).add(v);
                        inDegree.put(v, inDegree.get(v) + 1);
                    }
                    break; // No need to check further
                }
            }
        }

        // Step 3: Perform Topological Sorting (DFS)
        StringBuilder order = new StringBuilder();
        boolean[] visited = new boolean[26];
        boolean[] currentPath = new boolean[26];

        for (char node : adjList.keySet()) {
            if (!visited[node - 'a']) {
                if (!dfs(node, adjList, visited, currentPath, order)) {
                    return ""; // Cycle detected
                }
            }
        }

        return order.reverse().toString();
    }

    private boolean dfs(char node, Map<Character, Set<Character>> adjList, boolean[] visited,
                        boolean[] currentPath, StringBuilder order) {
        if (currentPath[node - 'a']) return false; // Cycle detected
        if (visited[node - 'a']) return true;

        visited[node - 'a'] = true;
        currentPath[node - 'a'] = true;

        for (char neighbor : adjList.get(node)) {
            if (!dfs(neighbor, adjList, visited, currentPath, order)) {
                return false;
            }
        }

        currentPath[node - 'a'] = false;
        order.append(node);
        return true;
    }
}

class SolutionBFSKahnAlgorithm {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Step 1: Initialize the graph
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjList.putIfAbsent(ch, new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }

        // Step 2: Build adjacency list and in-degree map
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];

            // Edge case: If "abc" appears before "ab", return ""
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char u = first.charAt(j), v = second.charAt(j);
                if (u != v) {
                    if (adjList.get(u).add(v)) {  // Avoid duplicate edges
                        inDegree.put(v, inDegree.get(v) + 1);
                    }
                    break; // Order is determined, no need to check further
                }
            }
        }

        // Step 3: Perform Topological Sorting using BFS
        Queue<Character> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();

        // Enqueue all nodes with in-degree = 0
        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            order.append(curr);

            for (char neighbor : adjList.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all characters are used, return the result; otherwise, a cycle exists.
        return order.length() == inDegree.size() ? order.toString() : "";
    }
}
