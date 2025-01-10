
// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    //aesha
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
                if(root == null) return result;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> widthq = new LinkedList<>();
        int max=0;
        int min=0;
        q.add(root);
        widthq.add(0);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            int currWidth = widthq.poll();

            if(!map.containsKey(currWidth))
            {
                map.put(currWidth, new ArrayList<>());
            }
            map.get(currWidth).add(curr.val);

            if(curr.left!=null)
            {
                q.add(curr.left);
                widthq.add(currWidth-1);
                min = Math.min(min, currWidth-1);
            }

            if(curr.right!=null)
            {
                q.add(curr.right);
                widthq.add(currWidth+1);
                max = Math.max(max, currWidth+1);
            }
        }

        for(int i = min;i<= max ;i++)
        {
            result.add(map.get(i));
        }
        return result;
    }
}