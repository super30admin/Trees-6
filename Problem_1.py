"""
Time Complexity : O(n) - worst case
Space Complexity : O(h) stack height
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        result = 0
        stack = []
        stack.append(root)
        while stack:
            root = stack.pop()
            if not root:
                continue
            if root.val >= low and root.val <= high:
                result += root.val
            if root.val < high:
                stack.append(root.right)
            if root.val > low:
                stack.append(root.left)
        return result

# class Solution:
#     def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
#         self.result=0
#         self.helper(root,low,high)
#         return self.result

#     def helper(self, root,low,high):
#         if not root:
#             return
#         if root.val>=low and root.val<=high:
#             self.result+=root.val
#         if root.val>low:
#             self.helper(root.left,low,high)
#         if root.val<high:
#             self.helper(root.right,low,high)
