# Recursion
# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
      
        # make a global variable to store the sum of results
        self.res = 0
        
        # define recursive dfs function for inorder traversal
        def dfs(root, low, high):
            # base case
            # if root is None, then return
            if not root:
                return
              
            # if the value of root is greater than low, only call the dfs on root.left
            if root.val > low:
                dfs(root.left, low, high)
            
            # if the value of root is within the given low and high range, then add it to the sum
            if root.val >= low and root.val <= high:
                self.res += root.val
            
            # if the value of root is lower than high, only call the dfs on root.right
            if root.val < high:
                dfs(root.right, low, high)
        
        # call the dfs function with root
        dfs(root, low, high)
        
        # return the final result
        return self.res
