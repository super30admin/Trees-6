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
      
        # make a res variable as 0, which will be used to sum up the values of the tree within the range
        res = 0
        
        # add the root to the stack
        stack = [root]
        
        # traverse until the stack is not empty
        while stack:
          
            # pop the top element from the stack
            node = stack.pop()
            
            # if node is not null
            if node:
                
                # if the node value is greater than low, then append the node.left to the stack
                if node.val > low:
                    stack.append(node.left)
                
                # check if the current node is within the range, then add to the res
                if node.val >= low and node.val <= high:
                    res += node.val
                
                # if the node value is lesser than high, then append the node.right to the stack
                if node.val < high:
                    stack.append(node.right)
        
        # return res
        return res
