# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        #can hit all nodes and see if low high in range. 
        """
        need to do optimization. (ON BOTTOM)
        """
        res = 0
        if not root:
            return res
        
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left 
            
            root = stack.pop()
            if root.val >= low and root.val <= high:
                res += root.val 
            
            root = root.right            
            
        return res


"""
WITH OPTIMIZATION
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        #can hit all nodes and see if low high in range.
        res = 0
        if not root:
            return res
        
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                if root.val > low:
                    root = root.left 
                else:
                    break
            
            root = stack.pop()
            if root.val >= low and root.val <= high:
                res += root.val 
            if root.val < high:
                root = root.right    
            else:
                break
            
        return res