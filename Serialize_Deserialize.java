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
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty())
        {
            TreeNode node = Q.poll();
            if(node != null)
            {
                sb.append(node.val);
                sb.append(",");
                Q.add(node.left);
                Q.add(node.right);
            }
            else
            {
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
        {
            return null;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        String ar[] = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(ar[0]));
        Q.add(root); i++;
        while(!Q.isEmpty())
        {
            TreeNode node = Q.poll();
            if(i < ar.length && !ar[i].equals("null"))
            {
                node.left = new TreeNode(Integer.parseInt(ar[i]));
                Q.add(node.left);
            }
            i++;
            if(i < ar.length && !ar[i].equals("null"))
            {
                node.right = new TreeNode(Integer.parseInt(ar[i]));
                Q.add(node.right);
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