# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        stack = [root]
        while stack:
            node = stack.pop()
            
            if not node:
                continue
            if root.val >= low and root.val <=high:
                result += root.val
            
            if root.val >= low:
                stack.append(root.left)
            
            if root.val <= high:
                stack.append(root.right)
        return result
        
        
    
    #dfs recursive
    def rangeSumBST_dfs(self, root: TreeNode, low: int, high: int) -> int:
        
        
        if not root:
            return 0
        self.result = 0
        self.dfs(root,low,high)
        return self.result
    
    
    def dfs(self,root,low,high):
        
        #base        
        if root == None:
            return
        
        #logic
        if root.val >= low and root.val <=high:
            self.result += root.val
        
        if root.val >= low:
            self.dfs(root.left,low,high)
            
        if root.val <= high:
            self.dfs(root.right,low,high)
        
