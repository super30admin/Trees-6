
// Time Complexity - O(n)
// Space Complexity - O(n)
// This Solution worked on LeetCode

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null)    sb.append(curr.val+","); 
            else sb.append("null,"); 
            if(curr != null){
                q.add(curr.left);
                q.add(curr.right);    
            }      
        }
        String res = sb.toString();
        while(!Character.isDigit(res.charAt(res.length()-1)))
            res = res.substring(0,res.length()-1);
        System.out.println(res);
        return res;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")  return null;
        String[] str = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i < str.length){
            TreeNode curr =  q.poll();
            if(curr != null){
                if(!str[i].equals("null")){
                    curr.left = new TreeNode(Integer.parseInt(str[i]));
                    q.add(curr.left);
                }  
                else 
                    curr.left = null;
                i++;
                if(i < str.length && !str[i].equals("null")){
                    curr.right = new TreeNode(Integer.parseInt(str[i]));
                    q.add(curr.right);
                }
                    
                else
                    curr.right = null;
                i++;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
