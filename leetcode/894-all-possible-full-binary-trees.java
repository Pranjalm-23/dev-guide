import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private HashMap<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        if (n % 2 == 0 || n < 3)
            return ans;

        for (int l = 0; l < n; l++) {
            int r = n - l - 1;
            List<TreeNode> left = allPossibleFBT(l);
            List<TreeNode> right = allPossibleFBT(r);
            // make all possible pairs
            for (TreeNode leftSubtree : left) {
                for (TreeNode rightSubtree : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftSubtree;
                    root.right = rightSubtree;
                    ans.add(root);
                }
            }
        }
        memo.put(n, ans);
        return ans;
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