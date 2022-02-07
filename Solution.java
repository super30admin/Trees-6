import java.util.*;

class Solution {
    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode(){

        }
    }
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return result;
    }
    private void inorder(TreeNode root, int low, int high){
        //base
        if(root == null) return;
        if(root.val >= low && root.val <= high) {
            result += root.val;
        }
        //logic
        inorder(root.left, low, high);
        inorder(root.right, low, high);
    }

    //o(n) time and o(n) space
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null )  return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root); cols.add(0);
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            List<Integer> temp = map.get(col);
            temp.add(curr.val);
            map.put(col, temp);
            if(curr.left != null) {
                q.add(curr.left);
                cols.add(col - 1);
            }
            if(curr.right != null) {
                q.add(curr.right);
                cols.add(col +  1);
            }
        }
        for(int i = min; i <= max; i++ ){
            result.add(map.get(i));
        }
        return result;
    
}

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
    //o(n) time 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null) sb.append("null");
            else sb.append(curr.val);
            sb.append(',');
            if(curr != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.length() == 0) return null;
        String[] strArray = data.split(",");
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[i]));
        i++;
        q.add(root);
        while(!q.isEmpty() && i < strArray.length){
            TreeNode curr = q.poll();
            if(!strArray[i].equals( "null")){
                curr.left = new TreeNode(Integer.parseInt(strArray[i]));
                q.add(curr.left);
            } 
            i++;
            if(!strArray[i].equals( "null")){
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
// TreeNode ans = deser.deserialize(ser.serialize(root)
}