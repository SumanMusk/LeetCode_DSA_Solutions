class Solution {
    public boolean isBalanced(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return true;
        que.add(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(!check(temp)) return false;
            if(temp.left != null) que.add(temp.left);
            if(temp.right != null) que.add(temp.right);
        }
        return true;
    }
    public boolean check(TreeNode root){
        int lHeight = (root.left == null) ? 0 : Height(root.left);
        int rHeight = (root.right == null) ? 0 : Height(root.right);
        if(Math.abs(lHeight - rHeight) > 1) return false;
        else return true;
    }
    public int Height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(Height(root.left), Height(root.right));
    }
}