import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//Time Complexity: O(n)
//Space Complexity: O(n)
// We use level-order (BFS) to serialize the tree by visiting nodes level by level and marking nulls with #.
// During deserialization, we use a queue to build the tree level-wise from the serialized string.
// We attach left and right children in order while reading each node from the string.
public class SerializeDeserializeBT {
    public String serialize(TreeNode root){
        if(root==null) return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr!=null)
            {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            else{
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
         if(data==null) return null;

         String[] splitArr = data.split(",");
         int idx = 0;

         TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
         idx++;
         
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);

         while(!q.isEmpty())
         {
            TreeNode curr = q.poll();

            if(!splitArr[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            }
            idx++;

            if(!splitArr[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.right);
            }
            idx++;
         }

         return root;

    }
}
