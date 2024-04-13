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
class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return ls;
        ls.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ls;
    }
}
/*class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return ls;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        ls.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}*/