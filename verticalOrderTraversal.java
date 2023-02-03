// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> val=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        
        q.add(root);
        val.add(0);
        
        while(!q.isEmpty()){
            int size=q.size();
            
            TreeNode curr=q.poll();
            int currval=val.poll();
            min=Math.min(currval,min);
            max=Math.max(currval,max);
            if(!map.containsKey(currval)){
                map.put(currval,new ArrayList<>());
            }
            map.get(currval).add(curr.val);
            
            if(curr.left!=null){
                q.add(curr.left);
                val.add(currval-1);
            }
            if(curr.right!=null){ 
                q.add(curr.right);
                val.add(currval+1);
            }
            
        }
        
        for(int i=min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}