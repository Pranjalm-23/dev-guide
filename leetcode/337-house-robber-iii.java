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
    public int rob(TreeNode root) {
        int[] res = dfsRob(root); // res - root: take & dont-take
        return Math.max(res[0], res[1]);
    }

    private int[] dfsRob(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };

        int[] left = dfsRob(root.left);
        int[] right = dfsRob(root.right);

        // with this root
        int with = root.val + left[1] + right[1];
        // skip
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] { with, skip };
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