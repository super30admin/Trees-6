class Solution{
    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
      
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(0);
      
        int min = 0;
        int max = 0;
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = cols.pull();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>())
              }
            map.get(col).add(curr.val);
          
            if(curr.left != null){
                q.add(curr.left);
                min = Math.min(min, col-1);
                cols.add(col-1);
            }
            if(curr.right != null){
                q.add(curr.right);
                max = Math.min(max, col+1);
                cols.add(col + 1);
            }
        }
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
      return result;
    }
  
  //TC: O(H)
  //SC: O(2H)
