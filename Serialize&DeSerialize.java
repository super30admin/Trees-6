// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: 

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q= new LinkedList<>();
        StringBuilder sb= new StringBuilder();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr==null){
                sb.append("#,");
                continue;
            }
            sb.append(curr.val + ",");

            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data=="") return null;
        Queue<TreeNode> q= new LinkedList<>();
        String values[]= data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i=1;
        while(q!=null && i<values.length){
            TreeNode parent= q.poll();
            if(!values[i].equals("#")){
                TreeNode left= new TreeNode(Integer.parseInt(values[i])); 
                parent.left=left;
                q.add(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right= new TreeNode(Integer.parseInt(values[i])); 
                parent.right=right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}