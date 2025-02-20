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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfsMaxPathSum(root);
        return maxSum;
    }

    private int dfsMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        ;

        int left = Math.max(0, dfsMaxPathSum(root.left));
        int right = Math.max(0, dfsMaxPathSum(root.right));

        maxSum = Math.max(root.val + left + right, maxSum);

        return root.val + Math.max(left, right);
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