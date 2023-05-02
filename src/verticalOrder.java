//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply BFS. For each left node, put level as current level -1 and
 * for each right node, put level as current level + 1. Put all these
 * node values in the respective map keys. Also maintain min and max
 * of the root values traversed. Iterate over the min to max to get
 * the list of values and return that list of lists.
 *
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
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            TreeNode curr =q.poll();
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
        for(int i = min; i<=max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
