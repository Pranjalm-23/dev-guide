class Solution {
    public int goodNodes(TreeNode root) {
        return dfsCountGood(root, root.val);
    }

    private int dfsCountGood(TreeNode node, int max) {
        if (node == null)
            return 0;

        int res = 0;
        if (node.val >= max)
            res++;
        res += dfsCountGood(node.left, Math.max(max, node.val));
        res += dfsCountGood(node.right, Math.max(max, node.val));

        return res;
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
