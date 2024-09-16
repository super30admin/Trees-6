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

/*
TC: O(n)
SC:O(n)
*/
class Solution {
    
    class Tuple{
        TreeNode node;
        int col;
        Tuple(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
        
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
       
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));
        
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int col = tuple.col;
            
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            
            
            if(node.left != null){
                queue.add(new Tuple(node.left, col-1));
                min = Math.min(min, col-1);
            }
            
            if(node.right != null){
                queue.add(new Tuple(node.right, col+1));
                max = Math.max(max, col+1);
            }
            
        }

        for(int i = min; i <= max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}