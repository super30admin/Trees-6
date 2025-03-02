//O(n)

public class SerializeDeserealize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            
            if(n==null){
                sb.append('#');
            }else{
                sb.append(n.val);
                q.add(n.left);
                q.add(n.right);
            }

            sb.append(',');
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data == null || data.length() == 0){
        return null;
       }
       String [] sArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
       int i=0;
       TreeNode root = new TreeNode(Integer.parseInt(sArr[i]));
       i++;
       q.add(root);
       while(!q.isEmpty()){
         TreeNode curr = q.poll();
         //left child
         if(!sArr[i].equals("#")){
            curr.left = new TreeNode(Integer.parseInt(sArr[i]));
            q.add(curr.left);
            
         }
         i++;
         //right child
         if(!sArr[i].equals("#")){
            curr.right = new TreeNode(Integer.parseInt(sArr[i]));
            q.add(curr.right);
         }
         i++;
       }
        return root;

    }
}
