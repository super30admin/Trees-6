// bfs
//Time complexity: O(n)
//Space complexity: O(n)

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
            }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if (curr == null){
                sb.append("null");
            }else{
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
        if(data.equals("")) return null;
        String [] strArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        q.add(root);
        i++;
        while (!q.isEmpty() && i < strArr.length){
            TreeNode curr = q.poll();
            if(!strArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;
            if(!strArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
            }
            i++;
                
            }
        return root;
        }
        
    }


/////////////////////////////////////////////// dfs

public class Codec {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        dfs(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")){
            return null;
        }
        String [] strArr = data.split(",");
        return dfsdfs(strArr);
    }
    
    // dfs
    public void dfs(TreeNode root){
        if (root == null){
            sb.append("null");
            sb.append(",");
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        dfs(root.left);
        dfs(root.right);
    }
    
    public TreeNode dfsdfs(String [] strArr){
        if (strArr[i].equals("null")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
        i++;
        root.left = dfsdfs(strArr);
        root.right = dfsdfs(strArr);
        return root;
    }
    
}
      
      
      
      
      
      
      
