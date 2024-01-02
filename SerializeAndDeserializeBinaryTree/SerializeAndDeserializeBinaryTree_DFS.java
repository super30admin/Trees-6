/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - height od the recursive stack */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//DFS
 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        //System.out.println(sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb){
        //base condn
        if(root == null) {
            sb.append("#");
            sb.append(",");
            return;
        }
        //logic
        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    int idx;
    String[] li;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        this.li = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(li[0]));
        idx++;
        deserializeHelper(root);
        return root;
    }

    private void deserializeHelper(TreeNode root){
        if(!li[idx].equals("#")){
            root.left = new TreeNode(Integer.parseInt(li[idx]));
            idx++;
            deserializeHelper(root.left);
        } else{
            idx++;
        }

        if(!li[idx].equals("#")){
            root.right = new TreeNode(Integer.parseInt(li[idx]));
            idx++;
            deserializeHelper(root.right);
        } else{
            idx++;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));