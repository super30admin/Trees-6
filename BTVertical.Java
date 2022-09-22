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
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    class pair{
        int level;
        int depth;
        
        pair(int level, int depth){
            this.level=level;
            this.depth=depth;
            
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<pair>>hm= new HashMap<>();
         List<List<Integer>>  ans= new ArrayList<>();
       helper(root,hm,0,0);
        
        for( int i=min;i<=max;i++){
            List<pair> out= hm.get(i);
            
            Collections.sort(out, new Comparator<pair>() {
                public int compare(pair p1, pair p2) {
                return p1.depth - p2.depth;}
            });
                List<Integer>temp= new ArrayList<>();
                for(pair p: out){
                    temp.add(p.level);
                    
                }
                ans.add(temp);
                
            }return ans;
        }
        
        
        
    
    
    public void helper(TreeNode root, HashMap<Integer, List<pair>>hm, int level, int depth){
        
        if(root==null){return;}
        
        if(!hm.containsKey(level)){
            
            hm.put(level,new ArrayList<>());
        }
        
        min=Math.min(min,level);
        max=Math.max(max,level);
        hm.get(level).add(new pair(root.val,depth));
        
        helper(root.left,hm,level-1,depth+1);
        helper(root.right,hm,level+1,depth+1);
        
    }
    
}
