// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : Te space complexity is O(n) where n is the number of tree nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //append to a string through BFS
        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur != null){
                sb.append(cur.val);
                sb.append(',');
                q.offer(cur.left);
                q.offer(cur.right);
            }
            else{
                sb.append("null");
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("null") || data.length() == 0) return null;
        String[] arr = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        int i=1;
        if(arr[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        //have two pointers, one for the current and other for the children
        while(i < arr.length){

            TreeNode cur = q.poll();

            if(!arr[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.left);
            }
            i++;

            if(!arr[i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.right);
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