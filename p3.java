// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        //null case
        if(root == null) return result;
        //using bfs, we need queue to store the node and it's width
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        q.add(root);
        q1.add(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //Go through all the nodes
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            int w = q1.poll();
            min = Math.min(min, w);
            max = Math.max(max, w);
            if(!map.containsKey(w)){
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(n.val);
            //left node
            if(n.left != null){
                 q.add(n.left);
                 q1.add(w-1);
            }
            //right node
            if(n.right != null){
                 q.add(n.right);
                 q1.add(w+1);
            }
        }
        
        //converting hashmap to arraylist
        for(int i = min; i<= max; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }
        return result;
    }
}