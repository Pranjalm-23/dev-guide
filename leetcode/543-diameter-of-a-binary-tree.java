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
    private int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfsHeight(root);
        return dia;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null)
            return 0;
        int lefth = dfsHeight(node.left);
        int righth = dfsHeight(node.right);
        dia = Math.max(dia, lefth + righth);
        return Math.max(lefth, righth) + 1;
    }
}