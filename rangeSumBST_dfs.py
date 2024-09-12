"""
Recursive solution - DFS solution 
TC= O(N)
SC=O(H)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        self.res=0
        if not root:
            return self.res
        self.dfs(root,low,high)
        return self.res
    
    
    def dfs(self,root,low,high):
        #base
        
        if(root==None):
            return self.res
        
        #logic
        if(root.val>=low and root.val<=high):
            self.res+=root.val
        if(root.val>low):
            self.dfs(root.left, low,high)
        if(root.val<high):
            self.dfs(root.right, low,high)
        
        
        