"""
Time Complexity : O(n) - worst case
Space Complexity : O(h) stack height
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root:
            return 0
        
        res = 0
        if L <= root.val and R >= root.val:
            res += root.val
            
        if L < root.val:
            res += self.rangeSumBST(root.left, L, R)
            
        if R > root.val:
            res += self.rangeSumBST(root.right, L, R)
            
        return res
        
        
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        result = 0
        stack = []
        stack.append(root)
        while stack:
            root = stack.pop()
            if not root:
                continue
            if root.val >= low and root.val <= high:
                result += root.val
            if root.val < high:
                stack.append(root.right)
            if root.val > low:
                stack.append(root.left)
        return result
