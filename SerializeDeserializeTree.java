// Time Complexity : O(n) serialize, O(n) deserialize
// Space Complexity : O(n), for both queue + arraylist 
// Did this code successfully run on Leetcode : 10/50 passed, bug in deserialization code

// Your code here along with comments explaining your approach
// temp work, will update after class

public class Codec {
    
    int maxDepth = 0;
    
    private void helper(TreeNode node, int curDepth){
        if(node==null)
            return;
        
        helper(node.left, curDepth+1);
        if(curDepth > maxDepth)
            maxDepth = curDepth;        
        helper(node.right, curDepth+1);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        
        maxDepth = 1;
        helper(root, 1);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node==null)
                    sb.append("null");
                else
                    sb.append(Integer.toString(node.val));
                
                if(node!=null && level<maxDepth){
                    queue.offer(node.left);
                    queue.offer(node.right);                    
                }
                
                sb.append(",");
            }
            
            level++;
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()<3)
            return null;
        
        String temp = data.substring(1, data.length()-1);
        String[] parts = temp.split(",");
        
        List<TreeNode> listOfNodes = new ArrayList<>();
        for(int i=0; i<parts.length; i++){
            if(parts[i].equals("null")){
                listOfNodes.add(null);
            }
            else{
                int val = Integer.parseInt(parts[i]);
                listOfNodes.add(new TreeNode(val));    
            }
        }
        
        TreeNode root = listOfNodes.get(0);
        int n = listOfNodes.size();
        for(int i=0; i<=(n/2)-1; i++){
            TreeNode node = listOfNodes.get(i);
            
            if(node!=null){
                node.left = listOfNodes.get((2*i)+1);    
                node.right = listOfNodes.get((2*i)+2);    
            }
        }
        
        return root;
    }
}