/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String str = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            str += "N";
            str += ",";
            return str;
        }
        if(root.val < 0) {
            str += "-";
            str += Integer.toString((root.val * -1));
        }
        else str += Integer.toString(root.val);
        str += ",";
        serialize(root.left);
        serialize(root.right);
        return str;
    }
    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        return helper(arr);
    }
    public TreeNode helper(String data[]) {
        if(data[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        if(idx < data.length) temp.left = helper(data);
        if(idx < data.length) temp.right = helper(data);
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

/*
public class Codec {
    String str = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            str += "N";
            return str;
        }
        str += Integer.toString(root.val);
        serialize(root.left);
        serialize(root.right);
        return str;
    }
    // Decodes your encoded data to tree.
    int i=0;
    public TreeNode deserialize(String data) {
        if(data.charAt(i) == 'N'){
            i++;
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(Character.toString(data.charAt(i))));
        i++;
        if(i < data.length()) temp.left = deserialize(data);
        if(i < data.length()) temp.right = deserialize(data);
        return temp;
    }
}
*/