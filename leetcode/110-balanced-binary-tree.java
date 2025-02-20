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

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsCheckBalance(root).isBalanced;
    }

    private ReturnInfo dfsCheckBalance(TreeNode node) {
        if (node == null)
            return new ReturnInfo(true, 0);

        ReturnInfo left = dfsCheckBalance(node.left);
        ReturnInfo right = dfsCheckBalance(node.right);

        boolean balanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        return new ReturnInfo(balanced, height);
    }

}

class ReturnInfo {
    boolean isBalanced;
    int height;

    ReturnInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}