// Time Complexity : O(nlog n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
  
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int column=0;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, column));
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> front = q.remove();
            TreeNode node = front.getKey();
            column = front.getValue();
            
            if(node!=null){
                if(!map.containsKey(column)){
                    map.put(column, new ArrayList<>());
                }
                map.get(column).add(node.val);
                q.add(new Pair(node.left, column-1));
                q.add(new Pair(node.right, column+1));
            }  
        }
        
        List<Integer> sorted = new ArrayList<>(map.keySet());
        Collections.sort(sorted);
        for(int n: sorted){
            res.add(map.get(n));
        }    
        return res;
    }

}