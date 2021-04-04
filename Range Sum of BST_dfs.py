#time: O(n)
#space: O(n)

#dfs


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        self.sum1=0
        def dfs(root):
            if(root==None):
                return
            if(low<=root.val<=high):
                self.sum1+=root.val
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        return self.sum1
            
            