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
// TC : O(n)
// SC : O(n)
// Method : BFS
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        int min = 0;
        int max = 0;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Integer> vals = new LinkedList<>(); 
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        vals.add(0);
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            int val = vals.poll();
            if(!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(curr.val);
            if(curr.left != null) {
                q.add(curr.left);
                vals.add(val-1);
            }
            if(curr.right != null) {
                q.add(curr.right);
                vals.add(val+1);
            }
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
