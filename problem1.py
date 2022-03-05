# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time complexity: O(n) where n is the number of Nodes
# Space complexity : O(n)

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root is None:
            return 0

        self.sum = 0

        self.dfs(root, low, high)

        return self.sum

    def dfs(self, root, low, high):
        # base case
        if root is None:
            return
        # logic
        self.dfs(root.left, low, high)

        if root.val >= low and root.val <= high:
            self.sum += root.val

        self.dfs(root.right, low, high)
