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
        
        if(root == null){
            return "";
        }
        
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            if(str.length() > 0){
                str.append(",");
            }
            
            if(current == null)
                str.append("null");
            else{
                str.append(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
            
        }
        
        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.length() == 0){
            return null;
        }
        
        String[] str = data.split(",");
        
        int index = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[index++])); 
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            
            String child1 = str[index++];
            String child2 = str[index++];
            
            if(!child1.equals("null")){
                curr.left = new TreeNode(Integer.parseInt(child1));
                queue.add(curr.left);
            }
            
            if(!child2.equals("null")){
                curr.right = new TreeNode(Integer.parseInt(child2));
                queue.add(curr.right);
            }
        }
        
        return root;
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));