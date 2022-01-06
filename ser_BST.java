// Time Complexity :O(O(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
      encode(root, sb);
      
      String output = sb.deleteCharAt(sb.length() - 1).toString();
      return output;
    }
    private void encode(TreeNode node, StringBuilder sb){
        if(node == null ){
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
        
        List<String> elements = new LinkedList<>(Arrays.asList(temp));
        return decode(elements);
    }
    
    private TreeNode decode(List<String> elements){
        if(elements.get(0).equals("null")){
            elements.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(elements.remove(0)));
        
        node.left = decode(elements);
        node.right = decode(elements);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));