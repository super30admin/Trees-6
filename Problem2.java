// 297 Serialize and Deserialize
// Time - O(n)
// Space - O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            if(curr == null){
                sb.append("null");
            }else{
                sb.append(curr.val);
            }
            
            sb.append(",");
            
            if(curr != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        int i = 0;
        String[] splitData = data.split(",");
        
        if(splitData[0].equals("null")){
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList();
        
        TreeNode root = new TreeNode(Integer.parseInt(splitData[0]));
        q.add(root);
        i++;
        
        while(!q.isEmpty() && i < splitData.length - 1){
            
            TreeNode curr = q.poll();
            
            if(curr != null){
                
                if(splitData[i].equals("null")){
                    
                    curr.left = null;
                }else{
                    
                    curr.left = new TreeNode(Integer.parseInt(splitData[i]));
                }
                
                q.add(curr.left);
                
                i++;
                
                if(splitData[i].equals("null")){
                    curr.right = null;
                }else{
                    
                    curr.right = new TreeNode(Integer.parseInt(splitData[i]));
                }
                
                q.add(curr.right);
                i++;
            }
            
        }
        
        return root;
    }
}