import java.util.LinkedList;
import java.util.Queue;
/*
Serialize and Deserialize Binary Tree
approach: use bfs
time: O(n)
space: O(n)
 */
public class Problem2 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int c) {
            this.val = c;
            this.left = null;
            this.right = null;
        }
    }

    StringBuilder stringBuilder;
    TreeNode root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode popped = queue.poll();
            if (popped==null) {
                stringBuilder.append("#");
            }
            else {
                stringBuilder.append(popped.val);
                queue.add(popped.left);
                queue.add(popped.right);
            }
            stringBuilder.append(",");
        }
        return stringBuilder.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int j = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        if (!nodes[0].equals("#"))
            root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        while (!queue.isEmpty() && j < nodes.length) {
            TreeNode curr = queue.poll();
            if (!nodes[j].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[j]));
                queue.add(curr.left);
            }
            j++;
            if (!nodes[j].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[j]));
                queue.add(curr.right);
            }
            j++;
        }
        return root;
    }
}
