//time complexity O(n) since in both functions we iterate over each node
//space complexity O(n) since we use queue

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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            } else{
                sb.append("null").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode (Integer.parseInt(str[i]));
        q.add(root);
        i++;
        while(!q.isEmpty() || i < str.length){
            TreeNode curr = q.poll();
            if(!str[i].equals("null")){
                curr.left = new TreeNode (Integer.parseInt(str[i]));
                q.add(curr.left);
            }
            i++;
            if(!str[i].equals("null")){
                curr.right = new TreeNode (Integer.parseInt(str[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
