# TC: O(n), where n - number of nodes
# SC: O(h), where h - height of the tree

class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0

        result = 0
        stack = []
        stack.append(root)

        while stack:
            curr = stack.pop()

            # If curr val is within the range, add to the sum
            if low <= curr.val <= high:
                result += curr.val

            # If curr val is greater than low, traverse to the left subtree
            if curr.val > low and curr.left:
                stack.append(curr.left)

            # If curr val is lesser than high, traverse to the right subtree
            if curr.val < high and curr.right:
                stack.append(curr.right)

        return result
