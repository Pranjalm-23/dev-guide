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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfsBuildBST(0, nums.length - 1, nums);
    }

    private TreeNode dfsBuildBST(int l, int r, int[] nums) {
        if (l > r)
            return null;

        int mid = l + (r - l) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.right = dfsBuildBST(mid + 1, r, nums);
        node.left = dfsBuildBST(l, mid - 1, nums);

        return node;
    }
}