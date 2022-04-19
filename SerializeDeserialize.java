
// Time Complexity : O(n)    
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of bfs to solve this problem

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("null");
                sb.append(",");
                continue;
            }
            sb.append(curr.val);
            sb.append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] strArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        q.add(root);
        int i =1;
        
        while(!q.isEmpty()){
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