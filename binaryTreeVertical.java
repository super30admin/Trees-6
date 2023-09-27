// tc : O(nlog(breadth))
// sc : O(n)

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
        // declare 
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        HashMap<Integer,  List<Integer>> map = new HashMap<>();
        int column = 0 ;

        // base case 
        if(root == null)
            return result;

        // logic
        q.offer(new Pair(root, column));
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> curr = q.poll();
            root = curr.getKey();
            column = curr.getValue();

            if(root == null)
                continue;
            map.computeIfAbsent(column, k -> new ArrayList<Integer>()).add(root.val);
            q.offer(new Pair(root.left,  column-1));
            q.offer(new Pair(root.right, column+1));
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedKeys);
        for(int ind : sortedKeys)
            result.add(map.get(ind));
        return result;
    }
}
