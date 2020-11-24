// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();      
    }
    
    private void rserialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
        } else{  
            sb.append(root.val).append(",");
            rserialize(root.left, sb);
            rserialize(root.right, sb);  
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // data = "1,2,3,X,X,4,5,"
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return rdesialize(q);
    }
    
    private TreeNode rdesialize(Queue<String> q){
        String data = q.remove();
        if("null".equals(data)){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(data));
            root.left = rdesialize(q);
            root.right = rdesialize(q);
            return root;
        }
    }
    

}
