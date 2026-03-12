# Time Complexity : O(N)  # In worst case we visit every node
# Space Complexity : O(H) # Recursion stack where H is tree height
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Since this is a BST, we can prune unnecessary branches.
# If node value is less than low, all left subtree values are smaller so skip left.
# If node value is greater than high, all right subtree values are larger so skip right.
# Otherwise include node value and explore both sides.

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        
        def dfs(node):
            if not node:
                return 0
            
            if node.val < low:
                return dfs(node.right)
            
            if node.val > high:
                return dfs(node.left)
            
            return node.val + dfs(node.left) + dfs(node.right)
        
        return dfs(root)