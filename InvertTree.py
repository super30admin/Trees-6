'''
Solution:
1.  This can be solved using either Depth First Traversal or Breadth First Traversal.
2.  When you hit a node in any traversal, process the value, that is, swap the left and right nodes.
3.  Return the final root after checking all nodes.

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


class InvertTreeRecursion:
    def invertTree(self, root: TreeNode) -> TreeNode:

        #   base case check
        if (root == None):
            return root

        #   recursion on left and right sub trees
        rightTree = self.invertTree(root.right)
        leftTree = self.invertTree(root.left)

        #   swap left and right sub trees
        root.right = leftTree
        root.left = rightTree

        #   return root
        return root


class InvertTreeBFT:
    def invertTree(self, root: TreeNode) -> TreeNode:

        #   edge case check
        if (root == None):
            return root

        #   add root to the queue
        queue = deque([root])

        #   iterate until queue is empty
        while (len(queue) > 0):

            #   remove the front node
            currentNode = queue.popleft()

            #   swap left and right subtrees
            tempTree = currentNode.right
            currentNode.right = currentNode.left
            currentNode.left = tempTree

            #   add left node to the queue
            if (currentNode.left != None):
                queue.append(currentNode.left)

            #   add right node to the queue
            if (currentNode.right != None):
                queue.append(currentNode.right)

        #   return root
        return root