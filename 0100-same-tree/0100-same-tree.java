class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean one = isSameTree(p.left, q.left);
        boolean two = isSameTree(p.right, q.right);
        return (one && two);
    }
}
/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add((p != null) ? p : null);
        que.add((q != null) ? q : null);
        while(!que.isEmpty()){
            TreeNode x = que.poll();
            TreeNode y = que.poll();
            if(x == null && y == null) continue;
            if(x == null || y == null) return false;
            if(x.val != y.val) return false;
            que.add((x.left != null) ? x.left : null);
            que.add((y.left != null) ? y.left : null);
            que.add((x.right != null) ? x.right : null);
            que.add((y.right != null) ? y.right : null);
        }
        return true;
    }
}
*/