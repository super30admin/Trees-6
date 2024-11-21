//time complexity-O(n)
//Space complexity-O(width of tree)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root== null) return 0;
        q.add(root);
        int ans=0;
        
        while(!q.isEmpty()){//BFS and adding all the numbers in which lie in the range

                TreeNode temp=q.poll();
                if(temp.val>=low && temp.val<=high)
                    ans+=temp.val;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
        }
        return ans;
        
    }
}