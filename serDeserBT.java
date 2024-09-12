// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
            if(curr != null){
                sb.append(curr.val);
                sb.append("#");
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("null");
                sb.append("#");
            }
        //System.out.println(sb.toString());
        
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] nodes = data.split("#");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < nodes.length){
            TreeNode curr = q.poll();
            if(!nodes[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
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
