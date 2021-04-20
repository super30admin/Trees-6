# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        sum1 = 0
        def preorder(root):
            if(root==None):
                return
            if(root.val>=low and root.val<=high):
                nonlocal sum1
                sum1+=root.val
                preorder(root.left)
                preorder(root.right)
            elif(root.val<low):
                preorder(root.right)
            else:
                preorder(root.left)
        
        preorder(root)
        return sum1
