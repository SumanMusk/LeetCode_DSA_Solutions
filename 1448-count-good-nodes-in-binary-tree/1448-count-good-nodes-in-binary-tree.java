class Solution {
    int count = 1;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count;
    }
    public void helper(TreeNode root, int max) {
        if(root.left != null){
            if(max <= root.left.val) count++;
            helper(root.left, Math.max(max, root.left.val));
        }
        if(root.right != null){
            if(max <= root.right.val) count++;
            helper(root.right, Math.max(max, root.right.val));
        }
    }
}