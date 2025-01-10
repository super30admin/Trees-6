// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    //aesha
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                sb.append(curr.val); 
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("#");
            }
            sb.append(",");
        }
        
        sb.setLength(sb.length() - 1); 
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      
if (data == null || data.isEmpty()) return null; // Handle empty input
        
        String[] splitArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[0]));
        q.add(root);
        
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (!splitArr[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            }
            idx++;
            if (idx < splitArr.length && !splitArr[idx].equals("#")) {
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