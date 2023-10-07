import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class SerializeAndDeserializeBTLevelOrder {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null)
            {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] splitArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[0]));
        q.add(root);
        int idx = 1;
        while(idx<splitArr.length)
        {
            TreeNode curr = q.poll();
            if(!splitArr[idx].equals("#") )
            {
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            }
            idx++;

            if(!splitArr[idx].equals("#") )
            {
                curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));