# problem 1


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result = 0 
        self.helper(root,low,high)
        return self.result 

    def helper(self,root,low,high):
        if not root:
            return 
        if root.val < low:
            self.helper(root.right,low,high)
            return 
        if root.val > high:
            self.helper(root.left,low,high)
            return 
        self.result+=root.val 
        self.helper(root.left,low,high)
        self.helper(root.right,low,high)