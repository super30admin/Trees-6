// Time Complexity : O(N) where n is the number of nodes in the tree
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Use a queue traverse the tree in bfs manner, if we find null put "n" else the value
// Use "," to separate the values, return the string
// For decoding split the string by "," String building the tree using queue put the left and right children
// Add the child to queue and repeat. Finally return the root.

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
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            if(result.length() != 0)
                result.append(",");
            TreeNode cur = q.poll();
            if(cur == null){
                result.append("n");
            }
            else{
                result.append(cur.val);
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("n"))
            return null;
        String[] splits = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        q.add(root);
        int index = 1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(!splits[index].equals("n")){
                cur.left = new TreeNode(Integer.parseInt(splits[index]));
                q.add(cur.left);
            }
            if(!splits[index+1].equals("n")){
                cur.right = new TreeNode(Integer.parseInt(splits[index+1]));
                q.add(cur.right);
            }
            index += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
















