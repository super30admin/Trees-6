# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional, TreeNode
#iterative method using stack
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        st = []
        result = 0

        while st or root != None:
            while root != None:
                st.append(root)
                if root.val > low:
                    root = root.left
                else:
                    root = None

            root = st.pop()
            if root.val >= low and root.val <= high:
                result+=root.val
            
            if root.val < high:
                root = root.right
            else:
                root = None
        
        return result
            


