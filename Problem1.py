# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        '''
        Time complexity- O(N), N ---> number of nodes in the BST, as we visit each node once. 
        Space complexity- O(H), H --> height of the BST, due to the recursion stack. 
        In the worst case, when the tree is skewed, the space complexity is O(N).
        '''
        # Initialize the sum to 0
        total_sum = 0

        def dfs(node):
            nonlocal total_sum
            # Base case: If the node is None, return
            if not node:
                return

            # Check if the node's value is within the specified range
            if low <= node.val <= high:
                total_sum += node.val

            # Explore the left and right subtrees
            dfs(node.left)
            dfs(node.right)

        # Start the depth-first search (DFS) from the root
        dfs(root)

        return total_sum
