#Approach
# Do the inorderTraversal and if node val is less than low dont explore left subtree

#Complexities
#Time: O(n)
#Space: o(n)



# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result = 0

        self.helper(root, low, high)
        return self.result

    def helper(self, root, low, high):
        if root == None:
            return
        if low <= root.val <= high:
            self.result += root.val
        if root.val > low:
            self.helper(root.left, low, high)
        if root.val <= high:
            self.helper(root.right, low, high)

