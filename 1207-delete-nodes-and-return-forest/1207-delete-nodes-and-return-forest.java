class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ls = new ArrayList<>();
        Set<Integer> set = new HashSet<>(){{for(int i: to_delete) add(i);}};
        dfs(root, set, ls);
        if(!set.contains(root.val))
            ls.add(root);
        return ls;
    }
    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> ls) {
        if(root == null)
            return null;
        root.left = dfs(root.left, set, ls);
        root.right = dfs(root.right, set, ls);
        if(set.contains(root.val)) {
            if(root.left != null)
                ls.add(root.left);
            if(root.right != null)
                ls.add(root.right);
            root.left = null;
            root.right = null;
            return null;
        }
        return root;
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