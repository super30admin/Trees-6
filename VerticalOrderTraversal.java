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
        if(root == null ) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> widthQ = new LinkedList<>();
        q.add(root);

        widthQ.add(0);
        int min = 0, max=0;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int currwidth = widthQ.poll();

            if(!map.containsKey(currwidth)){
                map.put(currwidth, new ArrayList<>());
            }
            map.get(currwidth).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                widthQ.add(currwidth-1);
                min = Math.min(min , currwidth-1);
            }

            if(curr.right!=null){
                q.add(curr.right);
                widthQ.add(currwidth+1);
                max = Math.max(max, currwidth+1);
            }


        }

        for(int i=min; i<=max; i++){
            result.add(map.get(i));
        }

        return result;
    }
}