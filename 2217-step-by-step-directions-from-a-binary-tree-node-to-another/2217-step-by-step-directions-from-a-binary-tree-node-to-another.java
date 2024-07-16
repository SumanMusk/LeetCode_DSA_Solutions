class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String startPath = path(root, startValue, new ArrayList<>());
        String destPath = path(root, destValue, new ArrayList<>());
        int i=0, j=0;
        while(i < startPath.length() && j < destPath.length()) {
            if(startPath.charAt(i) != destPath.charAt(j))
                break;
            i++;
            j++;
        }
        return startPath.substring(i, startPath.length()).replaceAll(".", "U") + destPath.substring(j, destPath.length());
    }

    public String path(TreeNode root, int destVal, List<Character> ls) {
        if(root == null) 
            return "";
        if(root.val == destVal) 
            return new StringBuilder(ls.stream().map(String::valueOf).collect(Collectors.joining())).toString();
        
        ls.add('L');
        String resOne = path(root.left, destVal, ls);
        if(!resOne.equals(""))
            return resOne;
        
        ls.removeLast();
        ls.add('R');
        String resTwo = path(root.right, destVal, ls);
        if(!resTwo.equals(""))
            return resTwo;
        
        ls.removeLast();
        return "";
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