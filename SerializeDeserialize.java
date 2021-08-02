//Did it run successfully on leetcode: yes
public class SerializeDeserialize {
    //time:O(n)
    //space: O(n) , n for queue
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
          
            
            if(curr!=null){
                sb.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }
            else{
                sb.append("null,");
            }
                 
        }
        
        sb.setLength(sb.length()-1);
        
        return sb.toString();
    }
    //time:O(n)
    //space: O(2n)->O(n) , n for queue and n for string array
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length() == 0) return null;
        
        String[] dataArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.add(root);
        int i=0;
        while(i<dataArr.length){
            TreeNode curr = q.poll();
            i++;
            if(i<dataArr.length && !dataArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(curr.left);
            }
            i++;
            if(i<dataArr.length && !dataArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(curr.right);
                
            }
            
        }
        return root;
        
    }
}