/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
 * Approach:
 * Use a Queue, and add all nodes there, parellely bbuild strinbuilder
 * TC: O(n) + O(L) serialize = number of nodes ; deserialize = length of string.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

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
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        int idx = 1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();

            if (!arr[idx].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(parent.left);
            }
            idx++;
            if (!arr[idx].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(parent.right);
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