// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

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

    StringBuilder sb;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
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

    int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() ==0)
            return null;
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