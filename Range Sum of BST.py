# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        # Time O(n)
        # Space O(h) height of recursion stack
        # Perform an inorder traversal
        global res
        res = 0

        def inorder(node):
            global res
            if not node: return
            inorder(node.left)
            if low <= node.val <= high:
                res += node.val
            inorder(node.right)

        inorder(root)
        return res
