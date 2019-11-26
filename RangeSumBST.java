//Time complexity: O(N)
//Space Complexity: O(N)
//Solved using bfs method. return sum when tree is empty. store the root in the queue and while it is not empty for every value in queue check if it fullfills conditions >=L and <=R and add to sum if it does.
//For the left values to the current node that is > left bound add to queue and for right values to current node if less than R add to queue outside while loop return the sum.
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null)
        {
            return sum;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode currNode = q.remove();
            if(currNode.val>=L && currNode.val<=R)
            {
                sum+=currNode.val;
            }
            if(currNode.left!=null && currNode.val>L)
            {
                q.add(currNode.left);
            }
            if(currNode.right!=null && currNode.val<R)
            {
                q.add(currNode.right);
            }
        }
        
        return sum;
        
    }
}