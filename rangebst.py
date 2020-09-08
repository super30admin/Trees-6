# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Iterative solution
# Time complexity - O(n) worst case
# Space complexity - O(h) - stack height
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.sumval = 0
        if not root: return self.sumval
        
        stack = deque([root])
        while stack:
            # pop the top most node from the stack 
            node = stack.pop()
            
            # add the node value to the result if it lies between a range.
            if L<=node.val<=R:
                self.sumval += node.val
                
            # add the left child to the stack
            if node.left and L<=node.val: 
                stack.append(node.left)
            
            # add the right child to the stack
            if node.right and R>=node.val: 
                stack.append(node.right)
            
        return self.sumval


# Iterative solution 2
# Using DFS
# Time complexity - O(n) worst case
# Space complexity - O(h) - stack height
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.sumValue = 0
        
        stack = deque()
        while stack or root is not None:
            while root:
                stack.append(root)
                # break it after the root value is added to the stack (even though it's less than the left value) because we still want to check it's right child.
                if root.val < L: 
                    break
                root = root.left
            
            root = stack.pop()
            # add the value to the sum value if it lies in the range.
            if L<= root.val <= R:
                self.sumValue += root.val
            
            # assign the right child as root if it is less than R.
            # else, assign the current root as None.
            if root.val < R: 
                root = root.right
            else:
                root = None
                
        return self.sumValue


# Using recursion - Using DFS
# Time complexity - O(n)
# Space complexity - O(h)
# Did this solution run on leetcode? - yes
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.sumValue = 0
        
        # dfs 
        def dfs(node, L, R):
            if not node:
                return 
        
            # add the value to the result, if it lies in the given range.
            if L <= node.val <= R:
                self.sumValue += node.val
            
            # recursively call the left and right child, if the value of the root is in between a range.
            if node.val<R:
                dfs(node.right, L, R)
            if node.val>L:
                dfs(node.left, L, R)
        
        dfs(root, L, R)
        return self.sumValue
        
        