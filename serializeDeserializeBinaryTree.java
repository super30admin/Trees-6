/*
Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
*/
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
    StringBuilder serialized = null;
    int index = 0;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialized = new StringBuilder();
        encode(root);
        return serialized.toString();
    }
    
    private void encode(TreeNode root) {
        if (root == null) {
            serialized.append("*");
            return;
        }
        
        serialized.append(root.val).append(",");
        encode(root.left);
        serialized.append(",");
        encode(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = -1;
        String nodes[] = data.split(",");
        return decode(nodes);
    }
    
    private TreeNode decode(String nodes[]) {
        ++index;
        if (index == nodes.length || nodes[index].equals("*")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        node.left = decode(nodes);
        node.right = decode(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));