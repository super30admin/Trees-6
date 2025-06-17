# Time Complexity : O(n)
# Space Complexity : O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        res = [0]

        def bin_dfs(node):
            if not node:
                return

            if low <= node.val <= high:
                res[0] += node.val

            if node.val >= low:
                bin_dfs(node.left)

            if node.val <= high:
                bin_dfs(node.right)

        bin_dfs(root)

        return res[0]