# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def __init__(self):
        self.sum = 0
        
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.helper(root, low, high)
        return self.sum
        
    
    def helper(self, node, low, high):
        if not node:
            return
        
        stack = list()
        
        while node or stack:
            while node:
                stack.append(node)
                if node.val < low:
                    break
                node = node.left
                
            node = stack.pop()
            
            if node.val >= low and node.val <= high:
                self.sum += node.val
            
            node = node.right
        
            
        
        
        
        