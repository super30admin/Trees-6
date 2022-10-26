//TC: O(n) traversing through all the nodes 
//SC: O(n) adding all the nodes into queue


// BFS order

//approach : mainatain a queue for level order traversal and a queue for the column
// a hashmap with col numbers as key and a list for the values in that column
// by BFS traverse through all the nodes
// The queues are corresponding to each other when left nodes and current cloumn-1 is related and it works similary


class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        q.add(root);
        cols.add(0);
         int min =0, max =0;
        while(!q.isEmpty()){ //no need to maintain size of level since in vertical order 
            TreeNode curr = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col,new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                cols.add(col-1);
                min = Math.min(min,col-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                cols.add(col+1);
                max = Math.max(max,col+1);
            }
            
        }
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        return res;
        
        
    }
}