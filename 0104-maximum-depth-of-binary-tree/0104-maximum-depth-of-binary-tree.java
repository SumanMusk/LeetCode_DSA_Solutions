class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return 1+Math.max(leftHeight, rightHeight);
        }
    }
}

/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else{
            Queue<TreeNode> que = new LinkedList<>();
            // depth=1 cz root node is also a level
            int depth=1;
            que.add(root);
            while(!que.isEmpty()){
                int len = que.size();
                // iterating all the level elements and adding the sub-tree elements in queue
                for(int i=0;i<len;i++){
                    TreeNode temp = que.poll();
                    if(temp.left != null) que.add(temp.left);
                    if(temp.right != null) que.add(temp.right);
                }
                if(!que.isEmpty()) depth++;
            }
            return depth;
        }
    }
}


*/