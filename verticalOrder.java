/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
     //TC:O(n)
     //sc:O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        int max = 0, min = 0;
        q.add(root);
        colq.add(0);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int ccol = colq.poll();
            if(!map.containsKey(ccol)){
                map.put(ccol,new ArrayList<>());
            }
            map.get(ccol).add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
                colq.add(ccol-1);
                min = Math.min(min,ccol-1);
            }
            if(curr.right != null){
                q.add(curr.right);
                colq.add(ccol+1);
                max = Math.max(max,ccol+1);
            }

           
        }
        for(int i = min; i<=max; i++){
            result.add(map.get(i));
        }
        return result;       
    }
}
