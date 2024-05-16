class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0)
            return false;
        if(root.val == 1)
            return true;
        boolean L = evaluateTree(root.left);
        boolean R = evaluateTree(root.right);
        if(root.val == 2)
            return L | R;
        if(root.val == 3)
            return L & R;
        return false;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */