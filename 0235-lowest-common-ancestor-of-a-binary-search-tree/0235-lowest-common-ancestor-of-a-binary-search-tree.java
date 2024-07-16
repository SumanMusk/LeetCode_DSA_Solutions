class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if the root node is in the range of the root's left and right child's node(1st example)
        if(p.val < q.val)
            if(p.val < root.val && q.val > root.val) return root;
        if(p.val > q.val)
            if(p.val > root.val && q.val < root.val) return root;
        // if one of the parent node is 'p' or 'q' and one of the child node is the remaining among 'p' or 'q'(2nd example) 
        if(root.val == p.val || root.val == q.val){
            if(root.val == p.val && ((root.left != null && root.left.val == q.val) || (root.right != null && root.right.val == q.val))) return p;
            else return q;
        }
        // else the sub-trees are checked according to the BST rules
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}

// Solve this questions:
// 236. Lowest Common Ancestor of a Binary Tree
// 2096. Step-By-Step Directions From a Binary Tree Node to Another