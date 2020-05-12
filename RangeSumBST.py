'''
Solution:
1.  This can be solved using either Depth First Traversal or Breadth First Traversal.
2.  When you hit a node in any traversal, process the value and if in range, just add to the final sum.
3.  Return the final sum after checking all nodes.

Time Complexity:    O(N)
Space Complexity:   O(H) for Depth First and O(N) for Breadth First

--- Passed all testcases successfully for both the solutions on leetcode.
'''

from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class RangeSumRecursion:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:

        #   base case check
        if (root == None):
            return 0

        #   if value in range
        if (root.val >= L and root.val <= R):
            return self.rangeSumBST(root.left, L, R) + root.val + self.rangeSumBST(root.right, L, R)

        #   if value less than left side in range => entire left sub tree gets pruned
        elif (root.val < L):
            return self.rangeSumBST(root.right, L, R)

        #   if value greater than right side in range => entire right sub tree gets pruned
        else:
            return self.rangeSumBST(root.left, L, R)


class RangeSumBFT:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:

        #   edge case check
        if (root == None):
            return 0

        #   initializations
        totalSum = 0
        queue = deque([root])

        #   iterate until queue is empty
        while (len(queue) > 0):

            #   remove the front node
            currentNode = queue.popleft()

            #   if value in range
            if (currentNode.val >= L and currentNode.val <= R):
                totalSum += currentNode.val
                if (currentNode.left != None):  queue.append(currentNode.left)
                if (currentNode.right != None):  queue.append(currentNode.right)

            #   if value less than left side in range => entire left sub tree gets pruned
            elif (currentNode.val < L):
                if (currentNode.right != None):  queue.append(currentNode.right)

            #   if value greater than right side in range => entire right sub tree gets pruned
            else:
                if (currentNode.left != None):  queue.append(currentNode.left)

        #   return total sum
        return totalSum