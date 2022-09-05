public class SerializeAndDeserialize {
     // Encodes a tree to a single string.
     //TC is O(n)
     //SC is O(n)
     public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // sb.append(root.val)
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("null");
            }
            sb.append(",");
            
        }
        return sb.toString();
    }

    //TC is O(n)
     //SC is O(n)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int i=1;
        if(nodes.length == 0 || nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        while(!q.isEmpty() && i<nodes.length){
            TreeNode curr = q.poll();
            if(curr != null){
                if(!nodes[i].equals("null")){
                     curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                    q.add(curr.left);
                }
                i++;
                if(i<nodes.length){
                    if(!nodes[i].equals("null")){
                        curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                    
                    q.add(curr.right);
                }
                    i++;
                }
            }
        }
        return root;
    }
}
