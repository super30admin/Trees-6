# Time:- O(n)
# Space:- O(h) h=height of the tree
# Approach:- Using the property of a BST if root.val<low then there can be a value>low on the right child
# similarly if root.val>high there can be a value<high on the left child. 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        def rsumbst(root):
            if root is None:
                return 0
            if root.val<low:
                return rsumbst(root.right)
            if root.val>high:
                return rsumbst(root.left)
            return root.val+rsumbst(root.left)+rsumbst(root.right)
        return rsumbst(root)