//time complexity O(n)
//space complexity O(n+n+n/2) => O(n) since there are 2 queues and a hashmap

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(0);
        int min = 0; int max = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if(curr.right != null){
                q.add(curr.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
