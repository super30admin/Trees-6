from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         self.res = 0
#         def dfs(root,l,h):
#             if not root: return 
#             if root.val >= l and root.val <=h:
#                 self.res+=root.val
#             dfs(root.left,l,h)
#             dfs(root.right,l,h)
#         dfs(root,low,high)
#         return self.res
# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         self.res = 0
#         def dfs(root,l,h):
#             if not root: return 
#             if root.val >= l and root.val <=h:
#                 self.res+=root.val
#             if root.val >low:
#                 dfs(root.left,l,h)
#             if root.val <high:
#                 dfs(root.right,l,h)
#         dfs(root,low,high)
#         return self.res
# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         def dfs(root,l,h):
#             if not root: return 0
#             res = 0
#             if root.val >= l and root.val <=h:
#                 res+=root.val
#             if root.val >low:
#                 res+= dfs(root.left,l,h)
#             if root.val <high:
#                 res+= dfs(root.right,l,h)
#             return res
#         return dfs(root,low,high)
# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         q = deque([root])
#         res = 0
#         while q:
#             curr = q.popleft()
#             if low<=curr.val<=high:
#                 res+=curr.val
#             if curr.left:
#                 q.append(curr.left)
#             if curr.right:
#                 q.append(curr.right)
#         return res
# class Solution:
#     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
#         stack = [root]
#         res = 0
#         while stack:
#             curr = stack.pop()
#             if low<=curr.val<=high:
#                 res+=curr.val

#             if curr.left and curr.val >low:
#                 stack.append(curr.left)
#             if curr.right and curr.val<high:
#                 stack.append(curr.right)
#         return res

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        stack = []
        res = 0
        while stack or root:
            while root:
                stack.append(root)
                root=root.left
            root = stack.pop()
            if low<=root.val<=high:
                res+=root.val
            root=root.right
        return res