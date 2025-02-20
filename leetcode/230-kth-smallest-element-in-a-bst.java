import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            // go leftest
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            // pop 1
            curr = st.pop();
            k--;
            if (k == 0)
                return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}

class SolutionDFS {
    private int count;
    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = 0;
        dfsInorder(root, k);
        return ans;
    }

    private void dfsInorder(TreeNode root, int k) {
        if (root == null || count >= k)
            return;
        dfsInorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        dfsInorder(root.right, k);
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