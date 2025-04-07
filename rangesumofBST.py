# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Tc: O(n)
    # SC : O(h)
    def preorder(self,root,low,high):
        if root is None:
            return 0
        sumv = 0
        lval,rval = 0,0
        if low <= root.val <= high:
            sumv += root.val   
        lval = self.preorder(root.left,low,high)

        rval = self.preorder(root.right,low,high)
        return sumv+lval+rval

    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root is None:
            return 0
        sumv = self.preorder(root,low,high)
        return sumv
        