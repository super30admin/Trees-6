# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def helper(root):
            summ = 0
            if not root:
                return 0
            if root.val >= low:
                summ += helper(root.left)
            if root.val in range(low, high+1):
                summ += root.val
            if root.val <= high:
                summ += helper(root.right)
            return summ
        return helper(root)
