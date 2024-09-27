//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Perform normal bfs on the binary tree given by maintaining a hashmap of vertical columns, whenever we are
// adding a left element add we decrease by 1 and right increase by 1. In this way keep appending similar cols to the List
// in hashmap and at the end iterate from min to max and add it to list of result.
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
        Queue<Integer> col = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        q.add(root); col.add(0);
        int min = 0; int max = 0;
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            int val = col.poll();
            if(!map.containsKey(val))
            {
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(curr.val);
            if(curr.left != null)
            {
                q.add(curr.left);
                col.add(val -1);
                min = Math.min(min, val -1);
            }
            if(curr.right != null)
            {
                q.add(curr.right);
                col.add(val + 1);
                max = Math.max(max, val + 1);
            }
        }
        for(int i = min; i <= max; i++)
        {
            result.add(map.get(i));
        }
        return result;
    }
}