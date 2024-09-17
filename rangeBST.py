# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time: O(n)
#Space: O(N)
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        self.result = 0
        self.dfs(root,low,  high)
        return self.result
        
    def dfs(self,root,low,high):
        if root == None:
            return
        if root.val >= low and  root.val <= high:
            self.result += root.val
        if root.val >= low:    
            self.dfs(root.left,low,high)
        if root.val <= high:
            self.dfs(root.right,low,high)
        
        
        
        