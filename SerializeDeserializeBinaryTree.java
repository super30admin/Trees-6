//Time complexity : O(N)
//Space complexity : O(N) // Using queue in both the methods 

public class Codec {
     public String serialize(TreeNode root) {
        
        if(root == null)    return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        StringBuilder sbr = new StringBuilder();
        while(!queue.isEmpty()){
            int l = queue.size();
            while(l-- > 0){
                TreeNode curr = queue.poll();
                if(curr == null){
                    sbr.append("null ");
                }else{
                    sbr.append(curr.val).append(" "); // If current node is not null then only we will add its children into the queue otherwise we wouldn't
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return sbr.toString();
    }
    public TreeNode deserialize(String data) {
if (data == null || data.length() == 0) return null;
        String[] arr = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode (Integer.valueOf(arr[0]));
        
        int index = 1;
        queue.add(root);
        while(!queue.isEmpty() && index < arr.length){
            TreeNode curr = queue.poll();
            //Handling curr node only when it is not null
            if( !arr[index].equals("null") ){
                curr.left = new TreeNode( Integer.parseInt(arr[index] ) );    
                queue.add(curr.left);
            }
            index++;
            if( !arr[index].equals("null") ){
                curr.right = new TreeNode(Integer.parseInt(arr[index]) );
                queue.add(curr.right);
            }
            index++;
                
        }
        
        return root;
    }
    
}
