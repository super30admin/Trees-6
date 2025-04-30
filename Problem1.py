# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.summ = 0 
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        return self.helper(root,low,high)
    
    def helper(self, root: Optional[TreeNode], low: int, high: int) -> int:

        if root == None:
            return 0
        summ = 0
        if root.val >= low and root.val <= high:
            summ += root.val

        left = self.helper(root.left,low,high)

        right = self.helper(root.right,low,high)

        return left + right + summ
        