// Time Complexity : O(n), traverse all nodes
// Space Complexity : O(n), queue + hashmap 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// Idea is we need to build results column wise, assign each node a column#, root at 0, left at -1, right at +1
// as we do a bfs just append node in its column wise list, bfs ensures top node are at first, then as we populate columns and get to know min and max return result

class Solution {
    HashMap<Integer, List<Integer>> columnWise;
    int maxColumn=0, minColumn=0;
        
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root==null)
            return output;
        
        columnWise = new HashMap<>();
        
        bfs(root);
        
        for(int i=minColumn; i<=maxColumn; i++){
            output.add(columnWise.get(i));
        }
        
        return output;
    }
    
    private void bfs(TreeNode root){
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                Integer col = pair.getValue();
                addNodeToColumnWise(node, col);
                
                if(node.left!=null){
                    minColumn = Math.min(minColumn, col-1);
                    queue.add(new Pair<TreeNode, Integer>(node.left, col-1));    
                }
                if(node.right!=null){
                    maxColumn = Math.max(maxColumn, col+1);
                    queue.add(new Pair<TreeNode, Integer>(node.right, col+1));    
                }
                
            }
        }
    }
    
    private void addNodeToColumnWise(TreeNode node, int col){
        if(!columnWise.containsKey(col)){
            columnWise.put(col, new ArrayList<Integer>(Arrays.asList(node.val)));
        }
        else{
            columnWise.get(col).add(node.val);
        }
    }
}