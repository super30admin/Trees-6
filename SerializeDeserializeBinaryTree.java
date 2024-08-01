//Time Complexity : O(2n) ~ O(n)
//Space Complexity : O(n)
//Did this code run successfully on leetcode : yes
//Any problem you faced while writing this: No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr != null) {
                str.append(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            } else {
                str.append("#");
            }
            str.append(",");
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        queue.add(root);
        int idx = 1;
        while(idx < s.length) {
            TreeNode curr = queue.poll();
            if(!s[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(s[idx]));
                queue.add(curr.left);    
            }
            idx++;
            if(!s[idx].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(s[idx]));
                queue.add(curr.right);    
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