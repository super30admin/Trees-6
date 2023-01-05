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
        st.append(root)
        while st:
            root = st.pop()
            if root.val >= low and root.val <= high:
                result += root.val

            if root.val < high and root.right is not None:
                st.append(root.right)

            if root.val > low and root.left is not None:
                st.append(root.left)

        return result