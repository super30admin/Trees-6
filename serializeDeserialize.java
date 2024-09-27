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
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null) sb.append("null");
            else sb.append(curr.val);
            sb.append(",");
            if(curr != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        int i = 0;
        String[] strArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
        i++;
        q.add(root);
        
        while(!q.isEmpty() && i < strArr.length){
            TreeNode curr = q.poll();
            // left child
            if(!strArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;
            if(!strArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
