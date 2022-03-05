// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                sb.append(curr.val).append(',');
                q.add(curr.left);
                q.add(curr.right);
            }
            else {
                sb.append(curr).append(',');
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");
        int i = 1;    // this is an iterator, which is starting from 1 since we already put 0th value in queue

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // we put only non-negative numbers in the queue
        // we increase i for all cases, either null or non-null values
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(left);
                curr.left = left;
            }
            i++;

            if(!nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(right);
                curr.right = right;
            }
            i++;
        }

        return root;
    }
}