//938. Range Sum of BST - https://leetcode.com/problems/range-sum-of-bst/description/
//Time Complexity: O(n)
//Space Complexity: O(1)

//void based recursion
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high){
        //base case
        if(root == null) return;

        //edge case
        if(root.val >= low && root.val <= high){
            result += root.val;
        }

        //visiting each and every node
        helper(root.left, low, high);
        helper(root.right, low, high);
    }
}


//conditional based recursion
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high){
        //base case
        if(root == null) return;

        //edge case
        if(root.val >= low && root.val <= high){
            result += root.val;
        }
        //not visiting all the nodes
        //only the ones that satisfy the conditions
        if(root.val > low){
            helper(root.left, low, high);
        }
        if(root.val <high){
            helper(root.right, low, high);
        }

    }
}

//int based recursion
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }

    private int helper(TreeNode root, int low, int high){
        //base case
        if(root == null) return 0;
        int result = 0;

        //edge case
        if(root.val >= low && root.val <= high){
            result += root.val;
        }

        if(root.val > low){
            result += helper(root.left, low, high);
        }
        if(root.val <high){
            result += helper(root.right, low, high);
        }
        return result;
    }
}

//iterative inorder traversal
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        int result=0;

        while(root != null || !st.isEmpty()){
            //processes left children first
            while(root != null){ //left child
                st.push(root);
                root = root.left;
            }
            //root is null
            root = st.pop();
            if(root.val >= low && root.val <= high){ //root
                result += root.val;
            }
            root = root.right; //right child
        }
        return result;
    }
}

//level order traversal
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val >= low && curr.val <= high){
                result += curr.val;
            }

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return result;
    }
}