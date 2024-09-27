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
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    public String serialize(TreeNode root) {
        if(root == null)
            return "X";
        String leftSubtree = serialize(root.left);
        String rightSubtree = serialize(root.right);
        
        return root.val + "," + leftSubtree + "," + rightSubtree;
    }

    // Decodes your encoded data to tree.
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    public TreeNode deserialize(String data) {
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(stringQueue);
    }
    
    public TreeNode deserializeHelper(Queue<String> stringQueue){
        String value = stringQueue.poll();
        if(value.equals("X"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(stringQueue);
        node.right = deserializeHelper(stringQueue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));