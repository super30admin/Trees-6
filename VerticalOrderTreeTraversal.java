// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class VerticalOrderTreeTraversal {
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
            if(root == null)
                return result;

            Map<Integer, List<Integer>> map = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            Queue<Integer> col = new LinkedList<>();
            q.add(root);
            col.add(0);
            int min = 0;
            int max = 0;

            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                int currCol = col.poll();

                if(!map.containsKey(currCol)){
                    map.put(currCol, new ArrayList<>());
                }
                map.get(currCol).add(curr.val);

                min = Math.min(min, currCol);
                max = Math.max(max, currCol);

                if(curr.left != null){
                    q.add(curr.left);
                    col.add(currCol - 1);
                }

                if(curr.right != null){
                    q.add(curr.right);
                    col.add(currCol + 1);
                }
            }

            for(int i = min; i <= max; i++){
                result.add(map.get(i));
            }

            return result;
        }
    }
}
