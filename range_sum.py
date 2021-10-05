# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity: O(N)

#Space Complexity: O(logN) 
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return root
        self.total = 0
        
        def dfs(node):
            if not node:
                return
            if node.val > low:
                dfs(node.left)
            if low <= node.val<= high:
                self.total+=node.val
            if node.val <  high:
                dfs(node.right)
        dfs(root)
        return self.total