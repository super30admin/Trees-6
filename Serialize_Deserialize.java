/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //TimeComplexity:O(n)
 public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return "";
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current == null) {
                sb.append('#');
            } else {
                sb.append(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        int index=0;
        String []arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(!arr[index].equals("#")) {
            current.left = new TreeNode(Integer.parseInt(arr[index]));
            queue.add(current.left);
            
            }
            index++;
             if(!arr[index].equals("#")) {
            current.right = new TreeNode(Integer.parseInt(arr[index]));
            queue.add(current.right);
             }
            index++;
        }
     return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));