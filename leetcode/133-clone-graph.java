import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class SolutionBFS {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        q.offer(node);
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        while (!q.isEmpty()) {
            Node old = q.poll();

            for (Node neighbor : old.neighbors) {
                if (oldToNew.containsKey(neighbor)) {
                    oldToNew.get(old).neighbors.add(oldToNew.get(neighbor));
                } else {
                    Node neiCopy = new Node(neighbor.val);
                    oldToNew.get(old).neighbors.add(neiCopy);
                    oldToNew.put(neighbor, neiCopy);
                    q.offer(neighbor);
                }
            }
        }
        return copy;
    }
}

class SolutionDFS {
    private HashMap<Node, Node> old2New = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (old2New.containsKey(node))
            return old2New.get(node);

        Node copy = new Node(node.val);
        old2New.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(cloneGraph(nei));
        }
        return copy;
    }
}