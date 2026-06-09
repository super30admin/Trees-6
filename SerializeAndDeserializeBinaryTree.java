// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
For serialize, we use BFS to do level order traversal and append the nodes using '#' if null child is found.
For deserialize, we use queue and construct the treenodes using level order traversal and form left and
right children for each node wherever applicable.
 */
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
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(curr != null) {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            else {
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] splitData = data.split(",");
        int idx = 0;

        TreeNode root = new TreeNode(Integer.parseInt(splitData[idx]));
        idx++;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!splitData[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(splitData[idx]));
                q.add(curr.left);
            }
            idx++;
            if(!splitData[idx].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(splitData[idx]));
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