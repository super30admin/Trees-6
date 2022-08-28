/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//preorder
//TC , SC - O(n) , O(h)
public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        if(root == null) return "";
        sb = new StringBuilder();
        serialHelper(root);
        return sb.toString();
    }
    private void serialHelper(TreeNode root){
        if(root == null){
            sb.append("null");
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialHelper(root.left);
        serialHelper(root.right);
    }

    // Decodes your encoded data to tree.
    int i;
    public TreeNode deserialize(String data) {
        if(data == null || data.length() ==0) return null;
        String [] strArr = data.split(",");
        
        return deserialHelper(strArr);
    }
    private TreeNode deserialHelper(String [] strArr){
        if(strArr[i].equals("null")){
           i++;
           return null; 
        } 
        TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
        i++;
        root.left = deserialHelper(strArr);
        root.right = deserialHelper(strArr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
