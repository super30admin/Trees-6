#Time:O(n)
#Space:O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root is None:
            return
        self.sum=0
        stack=[]
        while root or stack:
            while root :
                stack.append(root)
                root=root.left
            root= stack.pop()
            if low<=root.val<=high:
                self.sum+=root.val
            root=root.right
        return self.sum
