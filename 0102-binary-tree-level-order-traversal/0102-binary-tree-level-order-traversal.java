class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return ls;
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node = que.poll();
                temp.add(node.val);
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            ls.add(temp);
        }
        return ls;
    }
}