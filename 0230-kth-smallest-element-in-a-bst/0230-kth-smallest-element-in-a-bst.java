class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        helper(root, k, ls);
        return ls.get(k-1);
    }
    public void helper(TreeNode root, int k, List<Integer> ls) {
        if(k == 0) return;
        if(root.left != null) helper(root.left, k, ls);
        ls.add(root.val);
        k--;
        if(root.right != null) helper(root.right, k, ls);
    }
}