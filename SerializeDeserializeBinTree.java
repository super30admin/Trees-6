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
    /** Time complexity : O(N)
     * Space complexity: O(N)
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null");
                sb.append(",");
                continue;
            }

            sb.append(curr.val);
            sb.append(",");

            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    /** Time complexity : O(N)
     * Space complexity: O(N)
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] strArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        q.add(root);
        int i = 1;

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!strArr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;
            if(!strArr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
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