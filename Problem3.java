// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.add(root);
        level.add(0);
        int min = 0, max = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int lev = level.poll();
            if(!map.containsKey(lev))
                map.put(lev ,new ArrayList<>());
            map.get(lev).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                level.add(lev-1);
                min = Math.min(min,lev-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                level.add(lev+1);
                max = Math.max(max,lev+1);
            }
        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}