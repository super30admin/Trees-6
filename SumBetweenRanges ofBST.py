#Time Complexity:O(n)
#Space:O(n)
#Successfully ran on leetcode
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root is None:
            return 0
        queue = [root]
        total = 0
        while queue:
            root = queue.pop(0)
            if root.val>=low and root.val<=high:
                total+=root.val
            if root.left:
                queue.append(root.left)
            if root.right:
                queue.append(root.right)
        return total