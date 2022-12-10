/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time - O(n)
 //Space - O(1)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode el = q.poll();
            if(el == null){
                sb.append("null");
            }else{
            sb.append(el.val);
            q.add(el.left);
            q.add(el.right);
            }
            sb.append(",");

        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(",");
        if(nodes[0].equals("null" )) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int i=0;
        i++;
        while(!q.isEmpty() && i< nodes.length){
            TreeNode curr = q.poll();
             if(!nodes[i].equals("null" )){
                curr.left =  new TreeNode(Integer.parseInt(nodes[i]));;
                q.add(curr.left);                 
             }
             i++;
             if(!nodes[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
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