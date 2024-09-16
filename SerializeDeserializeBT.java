//Time - O(n)
// Space - O(n)

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
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return sb.toString();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr!= null)
                    sb.append(curr.val).append(',');
                else
                    sb.append("null").append(',');
                
                if(curr!= null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data == null || data.length() ==0)
           return null;
        
        
        String[] s = data.split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int cursor = 1;
        while(!q.isEmpty()){
           TreeNode parent = q.poll();
      
            if(!s[cursor].equals("null")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(s[cursor]));
                parent.left = leftChild;
                q.add(leftChild);
            }
            cursor++;
            if(!s[cursor].equals("null")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(s[cursor]));
                parent.right = rightChild;
                q.add(rightChild);
            }
            cursor++;
        }
        
        return root;
    }
        
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
