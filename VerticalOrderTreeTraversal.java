// TC: O(n)
// SC: O(n)

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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        bfs.add(root);
        cols.add(0);

        while(!bfs.isEmpty()){
            TreeNode curr = bfs.poll();
            int col = cols.poll();

            if(!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(curr.val);

            TreeNode left = curr.left;
            TreeNode right = curr.right;

            if(left != null){
                bfs.add(left);
                cols.add(col - 1);
            }

            if(right != null){
                bfs.add(right);
                cols.add(col + 1);
            }
            min = Math.min(min, col);
            max = Math.max(max, col);
        }

        for(int i = min; i<=max; i++){
            result.add(map.get(i));
        }

        return result;
    }
}
