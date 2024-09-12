# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS level order traversal. We initialize a queue and iterate until the queue is empty
# Then pop the node from the queue and check if the node value is >= low and <= high then add it to sum
# If the node has left child and node value is >= low then append it to queue.
# Since this is BST left child will always be lesser than root so we optimize it by checking the node value >= low before adding it to queue
# If the node has right child and node value is <= high then append it to queue
# Since this is BST right child will always be greater than root so we optimize it by checking the node value <= high before adding it to queue
# Return sum

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return None

        queue = deque([root])
        sumval = 0
        while queue:
            node = queue.pop()
            if node.left and node.val >= low:
                queue.append(node.left)
            if node.right and node.val <= high:
                queue.append(node.right)
            if node.val >= low and node.val <= high:
                sumval += node.val
        return sumval