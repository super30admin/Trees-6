# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        
        self.output=0
        
        def dfs(root,high,low):
            if not root:
                return
            if low<=root.val<=high:
                self.output+=root.val
            
            if root.val>=low:
                dfs(root.left,high,low)
            if root.val<=high:
                dfs(root.right,high,low)
                            
            
        dfs(root,high,low)
        return self.output
        
        