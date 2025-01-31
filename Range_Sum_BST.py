# Approach:
# Since the given tree is a Binary Search Tree (BST), we can utilize its properties to optimize our traversal.
# - If the current node's value is greater than high, then all values in the right subtree are also greater, 
#   so we only need to search the left subtree.
# - If the current node's value is less than low, then all values in the left subtree are also smaller,
#   so we only need to search the right subtree.
# - Otherwise, we add the current node's value to the sum and continue searching both subtrees.
# This allows us to avoid unnecessary traversal and achieve better efficiency.

# Time Complexity: O(n) in the worst case when the tree is unbalanced, O(log n) in the best case when the tree is balanced.
# Space Complexity: O(h), where h is the height of the tree (O(log n) for a balanced tree, O(n) in the worst case).

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        # Base case: If the node is None, return 0
        if not root:
            return 0
        
        # If node's value is greater than high, only check the left subtree
        if root.val > high:
            return self.rangeSumBST(root.left, low, high)
        
        # If node's value is less than low, only check the right subtree
        if root.val < low:
            return self.rangeSumBST(root.right, low, high)
        
        # If node's value is within range, add it to sum and check both subtrees
        return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)

# Test cases
root1 = TreeNode(10, 
                 TreeNode(5, TreeNode(3), TreeNode(7)), 
                 TreeNode(15, None, TreeNode(18)))
solution = Solution()
print(solution.rangeSumBST(root1, 7, 15))  # Output: 32

root2 = TreeNode(10, 
                 TreeNode(5, TreeNode(3, TreeNode(1)), TreeNode(7, TreeNode(6))), 
                 TreeNode(15, TreeNode(13), TreeNode(18)))
print(solution.rangeSumBST(root2, 6, 10))  # Output: 23
