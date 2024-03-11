class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int midIdx = 0;
        for(int i=0;i<inorder.length;i++) {
            if(preorder[0] == inorder[i]) {
                midIdx = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, midIdx+1), Arrays.copyOfRange(inorder, 0, midIdx));
        root.right = buildTree(Arrays.copyOfRange(preorder, midIdx+1, preorder.length), Arrays.copyOfRange(inorder, midIdx+1, inorder.length));
        return root;
    }
}