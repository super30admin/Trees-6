import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                sb.append("null");
                sb.append(",");
            } else {
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        if(sb.charAt(sb.length() - 1) == ',') sb.setLength(sb.length()-1);
        // System.out.println("string = "+sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") {
            return null;
        }

        String[] strs = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.add(root);
        int i = 1;

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!strs[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                curr.left = left;
                q.add(left);
            }
            i++;
            if(!strs[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                curr.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
