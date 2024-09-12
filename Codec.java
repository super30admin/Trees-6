// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        encode(root,sb);
        
        sb = sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
    
    public void encode(TreeNode node, StringBuilder sb) {
        
        if(node==null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        
        encode(node.left, sb);
        encode(node.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] temp = data.split(",");
        List<String> list = new LinkedList(Arrays.asList(temp));
        
        return decode(list);
        
    }
    
    public TreeNode decode(List<String> list) {
        
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = decode(list);
        node.right = decode(list);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
