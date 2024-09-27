
 // Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;

public class serialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        {
            return "";
        }
        Queue<TreeNode>q= new LinkedList<>();
        StringBuilder sb= new StringBuilder();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr= q.poll();
            
            if(curr!=null)
            {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            else
            {
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
        {
            return null;
        }
        int i=0;
        String[] str= data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(str[0]));
        i++;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr= q.poll();
            if(!str[i].equals("null"))
            {
                curr.left=new TreeNode(Integer.parseInt(str[i]));
                q.add(curr.left);
            }
            i++;
            if(!str[i].equals("null"))
            {
                curr.right=new TreeNode(Integer.parseInt(str[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));