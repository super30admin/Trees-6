"""TC - O(N)
SC -O(H)"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root == None:
            return 0

        self.dfs(root,low,high)
        return self.result
    
    def dfs(self,root,low,high):
        #base
        if root == None:
            return 
        if root.val>=low:
            self.dfs(root.left,low,high)
        #inorder
        if root.val>=low and root.val<=high:
            self.result+=root.val
        if root.val<=high:
            self.dfs(root.right,low,high)
        
        
        