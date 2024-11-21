class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        if(root == null){
            return result;
        }
        
        
        index.add(0);
        q.add(root);
        int min1 = 0;
        int max1 = 0;
    
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int ind = index.poll();
            if(!hmap.containsKey(ind)){
                hmap.put(ind, new ArrayList<>());   
            }
            hmap.get(ind).add(curr.val);
            
            if(curr.left != null){
                q.offer(curr.left);
                index.offer(ind - 1);
                min1 = Math.min(min1, ind - 1);
            }
            if(curr.right != null){
                q.offer(curr.right);
                index.offer(ind + 1);
                max1 = Math.max(max1, ind + 1);
            }
        }
        
        for(int i = min1; i <= max1; i++){
            result.add(new ArrayList<>(hmap.get(i)));
        }
        
        return result;
        
    }
}