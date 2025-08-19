// TC: O(n)
// SC: O(n)
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
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();

        bfs.add(root);
        sb.append(root.val);
        sb.append(",");

        while (!bfs.isEmpty()) {
            TreeNode curr = bfs.poll();
            if (curr == null) {
                continue;
            }

            bfs.add(curr.left);
            if (curr.left != null) {
                sb.append(curr.left.val);
            } else {
                sb.append("null");
            }

            sb.append(",");

            bfs.add(curr.right);
            if (curr.right != null) {
                sb.append(curr.right.val);
            } else {
                sb.append("null");
            }

            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] elements = data.split(",");
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(elements[0]);
        bfs.add(root);

        int i = 1;
        while (i < elements.length && !bfs.isEmpty()) {
            TreeNode curr = bfs.poll();
            if(curr == null){
                continue;
            }

            if(!elements[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(elements[i]));
            }else{
                curr.left = null;
            }
            bfs.add(curr.left);
            i++;

            if(!elements[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(elements[i]));
            }else{
                curr.right = null;
            }
            bfs.add(curr.right);
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));