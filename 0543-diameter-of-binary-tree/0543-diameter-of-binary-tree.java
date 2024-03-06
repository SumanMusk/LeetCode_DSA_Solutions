class Solution {
    int res = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        heightFunc(root);
        return res;
    }
    public int heightFunc(TreeNode root){
        if(root == null) return -1;
        int l_Height = heightFunc(root.left);
        int r_Height = heightFunc(root.right);
        res = Math.max(res, (l_Height + r_Height + 2));
        return 1 + Math.max(l_Height, r_Height);
    }
}