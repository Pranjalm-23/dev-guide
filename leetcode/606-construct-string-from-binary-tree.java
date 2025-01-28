/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        dfsBuildString(root, sb);
        return sb.toString();

    }

    private void dfsBuildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val);

        if (root.left != null || root.right != null) {
            sb.append('(');
            dfsBuildString(root.left, sb);
            sb.append(')');

            if (root.right != null) {
                sb.append('(');
                dfsBuildString(root.right, sb);
                sb.append(')');
            }
        }
    }
}

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