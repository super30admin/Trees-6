#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result=0
        self.helper( root, low, high)
        return self.result

    def helper(self, root, low, high):
        if not root:
            return self.result
        
        if low<=root.val<=high:
            self.result+=root.val

        self.helper(root.left, low, high)
        self.helper(root.right, low, high)

        