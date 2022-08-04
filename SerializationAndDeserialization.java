//Time: O(N) | Space: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                s.append("null");
            } else {
                s.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            s.append(',');
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        int n = splits.length;
        TreeNode root = n > 1 ? new TreeNode(Integer.parseInt(splits[i])) : null;
        if (root != null) {
            q.add(root);
            i++;

        }
        while (!q.isEmpty() && i < n) {
            TreeNode curr = q.poll();
            if (splits[i].equals("null")) {
                curr.left = null;
            } else {
                curr.left = new TreeNode(Integer.parseInt(splits[i]));
                q.add(curr.left);
            }
            i++;
            if (splits[i].equals("null")) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(Integer.parseInt(splits[i]));
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