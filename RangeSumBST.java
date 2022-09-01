//Iterative Pre-order traversal

//Time complexity : O(N)
//Space complexity : O(N)// As we used stack over here
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)    return 0;
        
        int sum = 0;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() ){
            TreeNode currNode = stack.pop();
            
            if(currNode.val >= low && currNode.val <= high){ //If current node's value is in between the low and high add it into the resultant sum
                sum += currNode.val;
            }
            
            if(!(currNode.val < low))
                if(currNode.left != null)   stack.push(currNode.left);
            
            if(!(currNode.val > high))
                if(currNode.right != null)  stack.push(currNode.right);
        }
        return sum;
    }
}
