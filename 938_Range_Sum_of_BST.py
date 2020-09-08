# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time Complexity : O(n) [n = number of nodes in Tree]
# Space Complexity : O(n) [n = number of nodes in Tree]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Problem approach
# 1. Traverse the Tree in preorer way
# 2. Add the value of current node if it falls within the range
# 3. Recusively call the dfs on left and right child if it falls within the range
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        res = 0
        def dfs(root):
            nonlocal res
            ## base
            if not root:
                return
            
            ## body
            if root.val >= L and root.val <= R:
                res+=root.val
            
            if root.val > L:
                dfs(root.left)
            
            if root.val < R:
                dfs(root.right)
        
        dfs(root)
        return res