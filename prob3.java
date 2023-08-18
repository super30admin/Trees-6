// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }
        
        Map<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root,0,0,map);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(List<int[]> values: map.values()){
            Collections.sort(values,(a,b)-> a[0]-b[0]);
             List<Integer> temp = new ArrayList<>();
            for(int[] val: values){
                temp.add(val[1]);
            }
            result.add(temp);
        }
        return result;
    }
    

    
    private void dfs(TreeNode root,int depth,int index,Map<Integer, List<int[]>> map ){
        if(root == null)
            return;
        
        if(!map.containsKey(index)){
            map.put(index,new ArrayList<>());
        }
        
        map.get(index).add(new int[]{depth,root.val});
        dfs(root.left,depth+1,index-1,map);
        dfs(root.right,depth+1,index+1,map);
    }
}