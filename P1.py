
## Problem1: Sum between two ranges of BST(https://leetcode.com/problems/range-sum-of-bst)
# TC : O(n)
# SC : O(1)
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.count = 0
        def dfs(root, low, high):
            if not root:
                return
            if low <= root.val <= high:
                self.count += root.val
            dfs(root.left, low, high)
            dfs(root.right, low, high)
        dfs(root, low, high)
        return self.count