import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deserializeIdx = 0;
        return dfsDeserialize(Arrays.asList(data.split(",")));
    }

    private int deserializeIdx = 0;

    private TreeNode dfsDeserialize(List<String> data) {
        if (deserializeIdx == data.size() || data.get(deserializeIdx).equals("null")) {
            deserializeIdx += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data.get(deserializeIdx)));
        deserializeIdx += 1;
        node.left = dfsDeserialize(data);
        node.right = dfsDeserialize(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
