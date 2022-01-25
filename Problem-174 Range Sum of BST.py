# 938. Range Sum of BST
# https://leetcode.com/problems/range-sum-of-bst/

# Logic: We check the node's value with the range. As it is a BST, 
# the left side would be strictly less than and right side will be 
# strictly greater than the parent. If the parent is greater than 
# low only then we check the left subtree. Similarly if the parent 
# is less than high, only then we check the right subtree.

# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _helper(self, node, low, high):
        if not node:
            return 0
        
        s = 0
        if node.val >= low:
            s += self._helper(node.left, low, high)
        
        if node.val <= high:
            s += self._helper(node.right, low, high)
        
        if low <= node.val <= high:
            s += node.val
        
        return s
    
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        return self._helper(root, low, high)