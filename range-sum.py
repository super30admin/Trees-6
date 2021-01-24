# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(H) -> height of tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: TreeNode
        :type low: int
        :type high: int
        :rtype: int
        """
        # RECURSIVE
        # Inorder traversal followed by sum
        range_sum = [0]
        def inorder(node):
            if node.left:
                inorder(node.left)
            if node.val > high:
                return
            if low <= node.val <= high:
                range_sum[0] += node.val
            if node.right:
                inorder(node.right)
                
        if not root:
            return 0
        inorder(root)
        return range_sum[0]