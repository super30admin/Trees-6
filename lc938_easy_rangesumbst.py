# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def dfs(root):
            if root:
                dfs(root.left)
                if root.val <= high and root.val >= low:
                    self.answer += root.val
                dfs(root.right)

        self.answer = 0
        dfs(root)
        return self.answer

