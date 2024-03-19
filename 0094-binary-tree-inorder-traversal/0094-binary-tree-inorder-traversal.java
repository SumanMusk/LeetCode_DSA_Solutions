class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return ls;
        if(root.left != null) inorderTraversal(root.left);
        ls.add(root.val);
        if(root.right != null) inorderTraversal(root.right);
        return ls;
    }
}