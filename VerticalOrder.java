// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity is O(n) where n is the number of tree nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        Queue<Integer> qIndex = new LinkedList<>();
        qIndex.offer(0);

        List<Integer> li = new ArrayList<>();
        li.add(root.val);
        map.put(0,li);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //store the nodes in a map based on its column index
        while(!q.isEmpty()){

            TreeNode cur = q.poll();
            int index = qIndex.poll();

            min = Math.min(min,index);
            max = Math.max(max,index);

            if(cur.left != null){
                li  = map.getOrDefault(index-1,new ArrayList<>());
                li.add(cur.left.val);
                map.put(index-1,li);

                q.offer(cur.left);
                qIndex.offer(index-1);
            }

            if(cur.right != null){
                li  = map.getOrDefault(index+1,new ArrayList<>());
                li.add(cur.right.val);
                map.put(index+1,li);

                q.offer(cur.right);
                qIndex.offer(index+1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        //traverse through the map and retrive the vertical order
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                res.add(map.get(i));
            }
        }
        return res;
    }
}