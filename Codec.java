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
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr != null){
                res.append(curr.val + ",");
                q.offer(curr.left);
                q.offer(curr.right);
            }else{
                res.append("N,");
            }
        } 
        //System.out.println(res.toString());
     return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int idx =0;
        if(nodes[0].equals("N"))
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++]));
        q.offer(root);

        while(!q.isEmpty() && idx < nodes.length){
            TreeNode curr = q.poll();

            //left child
            if(!nodes[idx].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[idx]));
                curr.left = left;
                q.offer(left);
            }
            idx++;
            //right child
            if(!nodes[idx].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[idx]));
                curr.right = right;
                q.offer(right);
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