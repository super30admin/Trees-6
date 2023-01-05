# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0

    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result = 0
        # if root is None:
        #     return self.result
        self.inorder(root, low, high)
        return self.result

    def inorder(self, root, low, high):
        # base
        if root is None:
            return
            # logic
        self.inorder(root.left, low, high)

        if low <= root.val <= high:
            # print(root.val, low, high)
            self.result += root.val

        self.inorder(root.right, low, high)
