'''
Time Complexity: O(N)
Space Complexity: O(N)
Did this code successfully run on Leetcode : Yes
Explanation:
Interchange left and right at the children just before leaf. While recursing upwards just replace the links with the other
side of the tree ie 2nd left left and right.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # interchange left and right at the children just before leaf
    # while iterating upwards just replace the links with the other side of the tree ie
    # 2nd left left and right
    # Iteration 1: 1 and 3 switch to 3 and 1 , same for 6 and 9.
    # When going up switch reference for 2 and 7
    def helper(self, root1: TreeNode):
        if root1 == None:
            return None
        left = self.helper(root1.left)
        right = self.helper(root1.right)
        root1.left = right
        root1.right = left

        return root1

    def invertTree(self, root: TreeNode) -> TreeNode:
        self.helper(root)
        return root