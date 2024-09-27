"""
time : o(n)
space : height of tree

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root : TreeNode, l : int, r : int):
        #base
        if not root: 
            return
        #logic:
        if root.val >= l and root.val <= r: #if current value lies within the range, add value to result
            self.res += root.val
        if root.val > l: #if current value is greater than l value, we will find more elements on the left so call dfs on left child
            self.dfs(root.left, l, r)
        if root.val < r: #if current value is lesser than r value, we will find more elements on the right so call dfs on right child
            self.dfs(root.right, l, r)
            
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.res = 0
        self.dfs(root, L, R)
        return self.res