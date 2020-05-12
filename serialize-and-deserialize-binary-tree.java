/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* For BST, any of the single traversal(DFT-Inorder, Preorder, Postorder/ BFT) is enough to serialize and deserialize. For BT, any of the single traversal(DFT-Inorder, Preorder, Postorder/ BFT) is enough to serialize and deserialize if preserve null values else we need combinations of DFT(In+Pre/In+Post). For N-ary trees, not possible with above ways (store size at each node OR delimiter after each level and children OR storing all children at each node if any)
*/
// Time Complexity : O(N) N being number of nodes in tree
// Space Complexity : O(N)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode current=q.poll();
            if(current == null) {
                sb.append("null,");
                continue;
            }
            sb.append(current.val+",");
            q.add(current.left);
            q.offer(current.right);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        q.add(root);
        int cursor=1;
        while(!q.isEmpty())
        {
            TreeNode current=q.poll();
            if(!tokens[cursor].equals("null")) {
                current.left=new TreeNode(Integer.parseInt(tokens[cursor]));
                q.offer(current.left);
            }
            cursor++;
            
            if(!tokens[cursor].equals("null")) {
                current.right=new TreeNode(Integer.parseInt(tokens[cursor]));
                q.offer(current.right);
            }
            cursor++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
