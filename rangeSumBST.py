# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.totalSum = 0
        def dfs(root):
            if root.val >= low and root.val <= high:
                self.totalSum += root.val
            if root.left:
                dfs(root.left)
            if root.right:
                dfs(root.right)

            return self.totalSum

        return dfs(root)
