class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long lBound, long rBound) {
        if(root == null) return true;
        if(root.val <= lBound) return false;
        if(root.val >= rBound) return false;
        boolean x = helper(root.left, lBound, root.val);
        boolean y = helper(root.right, root.val, rBound);
        return x && y;
    }
}
/*class Solution {
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    public void helper(TreeNode root, long lBound, long rBound) {
        if(lBound < root.val && root.val < rBound) {
            if(root.left != null){
                helper(root.left, lBound, root.val);
            }
            if(root.right != null){
                helper(root.right, root.val, rBound);
            }
        }
        else ans = false;
    }
}*/