public class RangeSumBST {

    //TC: O(n)
    //SC: O(h)
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return result;
    }

    private void helper(TreeNode root, int low, int high){
        if(root == null) return;

        if(root.val >= low && root.val <= high){
            result += root.val;
        }

        helper(root.left,low,high);
        helper(root.right,low,high);
    }

    /*  int based recursion
      public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
    }

     private int helper(TreeNode root, int low, int high){
        if(root == null) return 0;
        int curr = 0;

        if(root.val >= low && root.val <= high){
            curr = root.val;
        }


        int left = helper(root.left,low,high);
        int right = helper(root.right,low,high);

        return curr + left + right;
    }
    **/

    /**  Iterative Solution Inorder
     public int rangeSumBST(TreeNode root, int low, int high) {
     int result = 0;
     Stack<TreeNode> st = new Stack<>();
     while(root!=null || !st.isEmpty()){
     while(root!=null){
     st.push(root);
     root = root.left;
     }
     root = st.pop();
     if(root.val >= low && root.val <= high){
     result += root.val;
     }
     root = root.right;
     }

     return result;
     }
     */

    /**
     *  // post order traversal iterative solution
     *
     public int rangeSumBST(TreeNode root, int low, int high) {
     int result = 0;
     Stack<TreeNode> st = new Stack<>();
     TreeNode curr = root;
     TreeNode prev = null;
     st.push(curr);
     // post order traversal iterative solution
     while(!st.isEmpty()){
     curr = st.peek();

     if(prev == null || prev.left == curr || prev.right == curr){    // downward  with prev and curr
     if(curr.left!= null){
     st.push(curr.left);
     }else if(curr.right != null){
     st.push(curr.right);
     }else{
     curr = st.pop();
     System.out.println(curr.val);
     }

     if(curr.val >= low && curr.val <= high){  // calculate the result only in one movement
     result += curr.val;
     }

     }else if(curr.right!= null){        // upward  with prev and curr
     if(curr.right == prev){
     curr = st.pop();
     System.out.println(curr.val);
     }else{
     st.push(curr.right);
     }
     }else{
     curr = st.pop();
     System.out.println(curr.val);
     }
     prev = curr;
     }
     return result;
     }
     }
     */

}
