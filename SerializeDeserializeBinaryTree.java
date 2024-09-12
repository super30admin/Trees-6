/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC : O(N)
//TC : O(N)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            if(n.left==null)
            {
                sb.append("null");
                sb.append(",");
            }
            else
            {
                sb.append(n.left.val);
                sb.append(",");
                q.add(n.left);
            }
            if(n.right==null)
            {
                sb.append("null");
                sb.append(",");
            }
            else
            {
                sb.append(n.right.val);
                sb.append(",");
                q.add(n.right);
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;

        String[] dataArr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;

        while(idx<dataArr.length)
        {
            TreeNode n = q.poll();
            //System.out.println("idx : "+ idx + "value : "+dataArr[idx]);
            if(!dataArr[idx].equals("null"))
            {
                n.left = new TreeNode(Integer.parseInt(dataArr[idx]));
                q.add(n.left);
            }
            idx++;
            //System.out.println("idx : "+ idx + "value : "+dataArr[idx]);
            if(!dataArr[idx].equals("null"))
            {
                n.right = new TreeNode(Integer.parseInt(dataArr[idx]));
                q.add(n.right);
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