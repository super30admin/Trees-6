/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: BST can be converted in preorder or post order formeat for serializing and deserializing.
// Binary Search Tree property can be used while deserialization to identify null child nodes.

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        
        sb.append(root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] nodeVal = data.split(",");
        return deserializeHelper(nodeVal, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    int start = 0;
    private TreeNode deserializeHelper(String[] nodeVal, int low, int high) {
        if(nodeVal == null || start == nodeVal.length)
            return null;
        
        int curr = Integer.parseInt(nodeVal[start]);
        if(curr < low || curr > high)
            return null;
        
        TreeNode root = new TreeNode(curr);
        start++;
        root.left = deserializeHelper(nodeVal, low, curr);
        root.right = deserializeHelper(nodeVal, curr, high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
