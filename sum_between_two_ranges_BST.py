# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
from typing import Optional


class Solution:
    def __init__(self):
        self.result = 0
        self.stack = []

    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return self.result
        self.dfs(root, low, high)
        return self.result
        self.iterative(root, low, high)
        return self.result

    def iterative(self, root, low, high):
        self.stack.append(root)

        while self.stack:
            n = self.stack.pop()

            if n:
                #                 if it satisfy the base condition we will add it in result
                if low <= n.val <= high:
                    self.result += n.val
                #                 if it is greater  than and not equal we will add it to satck
                if n.left and low < n.val:
                    self.stack.append(n.left)
                #                  In case of right child if less than high we will add it to the stack
                if n.right and n.val < high:
                    self.stack.append(n.right)

    def dfs(self, root, low, high):

        if not root:
            return

        if root.val >= low and root.val <= high:
            self.result += root.val

        if root.left and root.val > low:
            self.dfs(root.left, low, high)

        if root.right and root.val < high:
            self.dfs(root.right, low, high)



