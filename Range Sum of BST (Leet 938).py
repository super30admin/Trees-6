# Time: O(h)
# Space: recursive stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = 0
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root is None:
            return 0
        self.res = 0
        self.dfs(root, low, high)
        return self.res
    
    def dfs(self, root, low, high):
        if root is None:
            return
        
        if low <= root.val and root.val <= high:
            self.res += root.val
            
        self.dfs(root.left, low, high)
        self.dfs(root.right, low, high)
