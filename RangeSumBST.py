#All TC passed on leetcode



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Here we can use BFS or DFS and check if cur node val is with range, if yes we add it to result else we dont.
    #time complexity - O(n) - visiting all nodes, even using BST worst case is visiting all nodes
    #space complexity - O(h) => O(n) - worst case it can be left sided tree
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        return self.helperWithBST(root, low, high)

    def helper(self, root, low, high):
        if not root:
            return 0

        temp = 0

        left = self.helper(root.left, low, high)
        right = self.helper(root.right, low, high)
        
        if root.val>=low and root.val<=high:
            temp = root.val
        
        return temp+left+right

    def helperWithBST(self, root, low, high):
        if not root:
            return 0

        temp = 0
        left = 0
        right = 0

        if root.val>low:
            left = self.helper(root.left, low, high)

        if root.val<high:
            right = self.helper(root.right, low, high)
        
        if root.val>=low and root.val<=high:
            temp = root.val
        
        return temp+left+right

        