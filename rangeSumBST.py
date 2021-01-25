#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        def calc(root):
            if root:
                if L <= root.val <= R:
                    self.total += root.val
                if L < root.val:
                    calc(root.left)
                if R > root.val:
                    calc(root.right)
        self.total = 0
        calc(root)
        return self.total
