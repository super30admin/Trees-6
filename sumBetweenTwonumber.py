# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.result = 0

    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        # if root is None: return 0

        # for stack implemntsation
        return self.stackimplement_preorder(root, low, high)

        # for dfs_retun functionality

        # return self.dfs_inorder_return(root, low, high)

    #  # for all void call
    # # self.result =self.dfs_preorder(root, low, high)
    #  return self.result

    def stackimplement_inorder(self, root, low, high):

        stack = []
        while stack.__len__() > 0 or root is not None:
            while root is not None:
                stack.append(root)
                root = root.left

            root = stack.pop()
            if root.val >= low and root.val <= high:
                self.result += root.val

            root = root.right

        print(self.result)
        return self.result

    def stackimplement_preorder(self, root, low, high):

        stack = []
        stack.append(root)
        while stack.__len__() > 0:

            root = stack.pop()
            if root.val >= low and root.val <= high:
                self.result += root.val

            if root.left is not None:
                self.stackimplement_preorder(root.left, low, high)
            if root.right is not None:
                self.stackimplement_preorder(root.right, low, high)

        return self.result

    def dfs_inorder_return(self, root, low, high):

        # base
        if root is None:
            return 0

        # logic

        exitsum = 0
        if root.val > low:
            exitsum += self.dfs_inorder_return(root.left, low, high)
        if root.val >= low and root.val <= high:
            exitsum += root.val

        if root.val < high:
            exitsum += self.dfs_inorder_return(root.right, low, high)
        return exitsum

    def dfs_preorder(self, root, low, high):

        # base
        if root is None:
            return

        # logic

        if root.val >= low and root.val <= high:
            self.result += root.val
        if root.val > low:
            self.dfs_preorder(root.left, low, high)

        if root.val < high:
            self.dfs_preorder(root.right, low, high)

    def dfs_postorder(self, root, low, high):

        # base
        if root is None:
            return

        # logic

        if root.val > low:
            self.dfs_preorder(root.left, low, high)

        if root.val < high:
            self.dfs_preorder(root.right, low, high)
        if root.val >= low and root.val <= high:
            self.result += root.val

    def dfs_inorder(self, root, low, high):

        # base
        if root is None:
            return

        # logic

        if root.val > low:
            self.dfs_preorder(root.left, low, high)
        if root.val >= low and root.val <= high:
            self.result += root.val

        if root.val < high:
            self.dfs_preorder(root.right, low, high)











