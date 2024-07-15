class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> chkParent = new HashSet<>();
        for(int arr[]: descriptions) {
            if(!map.containsKey(arr[0]))
                map.put(arr[0], new TreeNode(arr[0]));
            if(!map.containsKey(arr[1]))
                map.put(arr[1], new TreeNode(arr[1]));
            chkParent.add(arr[1]);
        }
        TreeNode root = null;
        for(int arr[]: descriptions) {
            if(arr[2] == 1)
                map.get(arr[0]).left = map.get(arr[1]);
            else
                map.get(arr[0]).right = map.get(arr[1]);
            if(!chkParent.contains(arr[0]))
                root = map.get(arr[0]);
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