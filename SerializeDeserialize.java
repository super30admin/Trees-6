// Time Complexity : O(N) for both operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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
        
        if(root == null) return sb.toString();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode curr = q.poll();
            
            if(curr != null) {
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("null");
                sb.append(",");
            }
            
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("")) return null;
        
        String[] strArray = data.split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        q.add(root);
        int i = 1;
        
        while(!q.isEmpty() && i < strArray.length) {
            
            TreeNode curr = q.poll();
            
            if(!strArray[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(strArray[i]));
                q.add(curr.left);
            }
            i++;
            
            if(!strArray[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(strArray[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));