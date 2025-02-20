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
    private int currSum;

    public TreeNode convertBST(TreeNode root) {
        currSum = 0;
        dfsconvertBST(root);
        return root;
    }

    private void dfsconvertBST(TreeNode root) {
        if (root == null)
            return;
        dfsconvertBST(root.right);
        currSum += root.val;
        root.val = currSum;
        dfsconvertBST(root.left);
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