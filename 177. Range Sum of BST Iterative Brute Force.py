# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        st = []
        result = 0

        while st or root:
            while root:
                st.append(root)
                if root.val >= low:
                    root = root.left
                else:
                    break

            root = st.pop()
            if low <= root.val <= high:
                result += root.val
            if root.val <= high:
                root = root.right
            else:
                break
        return result