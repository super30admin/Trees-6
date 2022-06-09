//Time Complexity : O(n); where n is total number of nodes in the tree.
//Space Complexity : O(H); where H is height of the tree.

public class RangeSumOfBST {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**Approach: DFS + Inorder**/
	int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }
    private void helper(TreeNode root, int low, int high){
        //base
        if(root == null) return; 
        
        //logic
        helper(root.left, low, high);
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        helper(root.right, low, high);        
    }   
    
	/** Driver code to test above **/
	public static void main (String[] args) {		
		RangeSumOfBST ob= new RangeSumOfBST();
		TreeNode t= new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
		int low= 7;
		int high= 15;
		System.out.println("Sum of the nodes within range ["+low+","+high+"] : "+ ob.rangeSumBST(t, low, high));		
	}
}
