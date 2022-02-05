/**
 // Time Complexity : O(n)
 // Space Complexity : O(n)
 
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
        
        StringBuilder sd = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        // level order traversal
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            // first element
            if (curr != null){
                sd.append(curr.val);
            }
            
            else {
                sd.append("null");
            }
            
            sd.append(',');
            
            // add left and right children
            
            if (curr != null){
                
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        
        // convert to string
        return sd.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {     
        
        int  i = 0;
        
        String[] s = data.split(",");
        
        if (s[0].equals("null")){
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
            
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
            
        q.add(root);
        
        
        i++;
        
        while(!q.isEmpty() && i < s.length - 1){
            
            TreeNode curr = q.poll();
            
            
             // create  left child 
            if (curr !=  null){
                
                if (!s[i].equals("null")){
                    
                    curr.left = new TreeNode(Integer.parseInt(s[i]));
                }

                q.add(curr.left);

                i++;

                // create  right child 
                if (!s[i].equals("null")){
                    curr.right = new TreeNode(Integer.parseInt(s[i]));
                }

                q.add(curr.right);

                i++;
            }
                        
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));