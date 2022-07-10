// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        StringBuilder result = new StringBuilder();
        
        while(queue.size() > 0) {
            
            TreeNode current = queue.poll();

            if(current == null) {
                result.append("null");
                result.append(",");
                continue;
            } 
            
            result.append(current.val);
            result.append(",");
            
            queue.add(current.left);
            queue.add(current.right);                

        }
        
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.length() == 0) {
            return null;
        } 
        
        String[] nodes = data.split(",");
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        
        queue.add(root);
        
        while(i < nodes.length) {
            TreeNode current = queue.poll();
            
            if(!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if(!nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}