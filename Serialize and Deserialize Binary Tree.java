//Time Complexity : O(n).Serialization : O(n), Deserialization : O(n)
//Space Complexity : O(n).Serialization : O(n), Deserialization : O(2n) ~ O(n)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return sb.toString();
        }
        //use queue to perform BFS
        Queue<TreeNode> q = new LinkedList<>();
        //initially add the root
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur!=null){
                //if not null, append the SB with roots value and add its left and right child to queue for next iteration
                sb.append(cur.val);
                sb.append(",");
                q.add(cur.left);
                q.add(cur.right);
            }          
           else{
               //otherwise append the string null
                sb.append("null");
                sb.append(",");
           }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        //Note : The data from serialization is passed as input here
        //use queue to perform BFS
        Queue<TreeNode> q = new LinkedList<>();
        //split the string 
        String[] arr = data.split(",");
        //add the first cell i.e root to the tree
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
        q.add(root);
        while(i<arr.length && !q.isEmpty()){
            TreeNode cur = q.poll();
            //left node
            if(!arr[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                cur.left = left;
                q.add(left);
            }
            i++;
            //right node
             if(!arr[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                cur.right = right;
                 q.add(right);
            }
            i++;
        }
        return root;
    }
}
