import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Serialize_And_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //edge case
        if(root == null)
        {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node != null)
            {
                str.append(Integer.valueOf(node.val));
                str.append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else
            {
                //append null
                str.append("null,");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(data==null || data.isEmpty() || arr.length==0) return null;
        Queue<TreeNode> q=new LinkedList<>();
        System.out.println(arr[0]);
        TreeNode root=new TreeNode(Integer.valueOf(arr[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length-1)
        {
            TreeNode temp=q.poll();
            if(!arr[i].equals("null"))
            {
                 temp.left=new TreeNode(Integer.valueOf(arr[i]));
                 q.add(temp.left);
            }
             if(!arr[i+1].equals("null"))
             {
                 temp.right=new TreeNode(Integer.valueOf(arr[i+1]));
                 q.add(temp.right);
             }
            i=i+2;
        }
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

//1, 2, 3, 
