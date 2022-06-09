import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(n); where n is total number of nodes in the tree.
//Space Complexity : O(n)
class BTVerticalOrderTraversal {
	/**Definition for binary tree node.**/	
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	/** Approach: Level Order Traversal**/
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root == null) return res; //null case        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        Queue<Integer> vq = new LinkedList<>();        
        q.add(root); vq.add(0);
        int max = 0; int min = 0;                
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int order = vq.poll();
            map.putIfAbsent(order, new ArrayList<>());
            map.get(order).add(curr.val);
            max= Math.max(max, order);
            min= Math.min(min, order);
            //add children to the queue
            if(curr.left!=null){
                q.add(curr.left);
                vq.add(order - 1);
            }            
            if(curr.right!=null){
                q.add(curr.right);
                vq.add(order + 1);
            }
        }        
        //Iterate over map keys and add the lists to result.
        for(int i=min; i<=max; i++){
            if(map.containsKey(i)){
                res.add(map.get(i));
            }
        }
        return res;
    }
	
	
	/** Driver code to test above **/
    public static void main(String args[]) {
    	BTVerticalOrderTraversal ob = new BTVerticalOrderTraversal();
    	//TreeNode t= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));	
    	TreeNode t= new TreeNode(3, new TreeNode(9, new TreeNode(4), new TreeNode(0)), new TreeNode(8, new TreeNode(1), new TreeNode(7)));
    	
		System.out.print("Vertical Order Traversal of BT :"+ ob.verticalOrder(t));		
    } 
}
