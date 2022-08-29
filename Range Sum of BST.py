#BFS

""""// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        q=deque()
        q.append(root)
        result=0
        while q:
            curr=q.popleft()
            if low<=curr.val<=high:
                result+=curr.val
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        return result






#DFS

""""// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         if not root:
#             return 0
#         self.result = 0
#         self.helper(root, low, high)
#         return self.result
#
#     def helper(self, root, low, high):
#         # base
#         if not root:
#             return
#
#         # logic
#         if root.val >= low:
#             self.helper(root.left, low, high)
#         if low <= root.val <= high:
#             self.result += root.val
#         if root.val <= high:
#             self.helper(root.right, low, high)


