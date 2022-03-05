// Time Complexity: O(n)
// Space Complexity: O(n)
public class SerializeDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null)
            {
                sb.append("null");
                sb.append(",");
                continue;
            }
            sb.append(curr.val);
            sb.append(",");
            q.offer(curr.left);
            q.offer(curr.right);
    
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        
        String [] strArray = data.split(",");
        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[idx++]));
        q.offer(root);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(!strArray[idx].equals("null"))
            {
                curr.left = new TreeNode(Integer.parseInt(strArray[idx]));
                q.offer(curr.left);
            }
            idx++;
            if(!strArray[idx].equals("null"))
            {
                curr.right = new TreeNode(Integer.parseInt(strArray[idx]));
                q.offer(curr.right);
            }
            idx++;   
        }
        
        return root;
    }
}
