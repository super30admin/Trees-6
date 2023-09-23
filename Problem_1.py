# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        s, nodes = 0, [root]
        while nodes:
            (node, nodes) = (nodes[0], nodes[1:])
            if ((node.val >= low) and (node.val <= high)):
                s += node.val
            if node.right: 
                nodes = ([node.right] + nodes)
            if node.left: 
                nodes = ([node.left] + nodes)
        return s