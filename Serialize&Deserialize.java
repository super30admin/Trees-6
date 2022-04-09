
//TC: o(n)
//SPace: 0(N)
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
        if(root == null)return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("null");
            }
             else{
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
             }
              sb.append(",");
        }
        
        return sb.toString();    
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)return null;
        String[] arr = data.split(",");
        int ele = Integer.parseInt(arr[0]);
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(ele);
        q.add(root);
        while(!q.isEmpty() && idx< arr.length){
            TreeNode curr = q.poll();
            if(!arr[idx].equals("null")){
                int ele1 = Integer.parseInt(arr[idx]);
                curr.left = new TreeNode(ele1);
            q.add(curr.left);
            }
             idx++;
            if(!arr[idx].equals("null"))
            {
                int ele2 = Integer.parseInt(arr[idx]);
                curr.right = new TreeNode(ele2); 
                 q.add(curr.right);
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
