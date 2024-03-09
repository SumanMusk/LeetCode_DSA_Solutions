class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot != null) return false;
        if(root != null && subRoot == null) return true;
        if(root != null && isSame(root, subRoot)) return true;
        boolean x = isSubtree(root.left, subRoot);
        boolean y = isSubtree(root.right, subRoot);
        return (x || y);
    }
    public boolean isSame(TreeNode firRoot, TreeNode secRoot){
        if(firRoot == null && secRoot == null) return true;
        if(firRoot == null || secRoot == null) return false;
        if(firRoot.val != secRoot.val) return false;
        boolean x = isSame(firRoot.left, secRoot.left);
        boolean y = isSame(firRoot.right, secRoot.right);
        return (x && y);
    }
}

/*
// solving with BFS Approach and using a Queue
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> que = new LinkedList<>();
        // we don't have to do the if(root == null) thing cause:-
        // Constraints:
        //    1. The number of nodes in the root tree is in the range [1, 2000]
        //    2. The number of nodes in the subRoot tree is in the range [1, 1000]
        
        // if(root == null){
        //    if(subRoot == null) return true;
        //    else return false;
        // }
        que.add(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(isSame(temp, subRoot)) return true;
            if(temp.left != null) que.add(temp.left);
            if(temp.right != null) que.add(temp.right);
        }
        return false;
    }
    public boolean isSame(TreeNode firRoot, TreeNode secRoot){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(firRoot);
        que.add(secRoot);
        while(!que.isEmpty()){
            TreeNode firNode = que.poll();
            TreeNode secNode = que.poll();
            if(firNode == null && secNode == null) continue;
            if(firNode == null || secNode == null) return false;
            if(firNode.val != secNode.val) return false;
            que.add((firNode.left != null) ? firNode.left : null);
            que.add((secNode.left != null) ? secNode.left : null);
            que.add((firNode.right != null) ? firNode.right : null);
            que.add((secNode.right != null) ? secNode.right : null);
        }
        return true;
    }
}
*/