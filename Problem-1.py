"""
TC: O(n)
SC: O(h) height of the tree
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result = 0
        self.helper(root, low, high)
        return self.result
    
    def helper(self, root, low, high):
        #base
        if not root:
            return
        
        #logic
        if root.val>low: self.helper(root.left, low, high)
        if low<= root.val <= high:
            self.result += root.val
        if root.val<high: self.helper(root.right, low, high)
        