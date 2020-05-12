'''
Accepted on leetcode(938)
time - O(N)
space - O(N)
Approach:
1. Using DFS traversal, traverse each node and check if it's value is greater than left and less than right given in the question.
2. If the condition satisfies add the value to the total and return total.
3. Each time for recursion, do it on left tree and right tree to check both left and right conditions.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    global L
    global R

    global total

    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        # edge case
        if root == None:
            return self.total

        # assignment
        self.L = L
        self.R = R

        self.total = 0

        # call recursive function
        self.sum(root)

        return self.total

    def sum(self, root):
        # base case
        if root == None:
            return

        # recursive case

        val = root.val

        if val >= self.L and val <= self.R:
            self.total += val

        if val >= self.L:  # left
            self.sum(root.left)

        if val <= self.R:  # right
            self.sum(root.right)