# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: Optional[TreeNode]
        :type low: int
        :type high: int
        :rtype: int
        """
        if root == None:
            return 0
        sum1 = 0
        stack = []
        while stack or root!= None:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val >= low and root.val <= high:
                sum1 = sum1 + root.val
            root = root.right

        return sum1

        # TC : O(n)
        # SC : O(h)