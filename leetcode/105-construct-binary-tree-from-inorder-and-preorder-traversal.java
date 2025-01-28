import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0)
            return null;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return dfsBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, idxMap);
    }

    private TreeNode dfsBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> idxMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int val = preorder[preStart];
        int rootidx = idxMap.get(val);
        int left = rootidx - inStart;
        TreeNode node = new TreeNode(val);
        node.left = dfsBuildTree(preorder, preStart + 1, preStart + left, inorder, inStart, rootidx - 1, idxMap);
        node.right = dfsBuildTree(preorder, preStart + left + 1, preEnd, inorder, rootidx + 1, inEnd, idxMap);
        return node;
    }
}