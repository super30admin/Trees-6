public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                s.append(curr.val);
                s.append(',');
                q.add(curr.left);
                q.add(curr.right);
            }else{
                s.append("null");
                s.append(',');
            }
        
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] s = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < s.length){
            TreeNode curr = q.poll();
            if(!s[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            
            if(!s[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
            
                
        }
        return root;
    }
}