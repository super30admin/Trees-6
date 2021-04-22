//time complexity-O(n)
//Space complexity-O(width of tree+hashmap length)
//Ran on leetcode-Yes
//Solution with comments-
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
        if(root==null)
            return new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();//Hashap to maintain the index with nodes
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        List<List<Integer>> ans= new ArrayList<>();
        
        while(!q.isEmpty()){//bfs on tree
            Pair<TreeNode,Integer> temp = q.poll();
            TreeNode n=temp.getKey();
            int val= temp.getValue();
            min=Math.min(min,val);
            max=Math.max(max,val);
            if(!map.containsKey(val))
                map.put(val,new ArrayList<>());
            map.get(val).add(temp.getKey().val);
            if(n.left!=null) q.add(new Pair<>(n.left,val-1));
            if(n.right!=null) q.add(new Pair<>(n.right,val+1));
        }
        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}