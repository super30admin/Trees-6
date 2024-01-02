/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - size of the queue */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//BFS

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            sb.append(",");
            if(curr.left != null){
                q.add(curr.left);
                sb.append(curr.left.val);
            } else {
                sb.append("#");
            }
            sb.append(",");
            if(curr.right != null){
                q.add(curr.right);
                sb.append(curr.right.val);
            } else {
                sb.append("#");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] li = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(li[0]));
        q.add(root);
        int idx = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!li[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(li[idx]));
                q.add(curr.left);
            }
            idx++;
            if(!li[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(li[idx]));
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