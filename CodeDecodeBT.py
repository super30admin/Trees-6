'''
Solution:
1.  For both serialization and deserialization, used BFT to perform code-decode operations.
2.  While serializing, all non-null nodes have been added to an array list by Breadth First Traversal.
3.  While deserializing, in the same order, all nodes have been allocated in their corresponding locations,
    be it left or right side for a particular node.

Time Complexity:    O(N)
Space Complexity:   O(N) for Breadth First

--- Passed all testcases successfully on leetcode.
'''

from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """

        #   edge case check
        if (root == None):
            return ''

        #   append the content or values to an array list
        nodes = []

        #   add root to the queue
        queue = deque([root])

        #   iterate until queue is empty
        while (len(queue) > 0):

            #   remove the front node and check for Null node
            currentNode = queue.popleft()
            if (currentNode == None):
                nodes.append(None)
                continue

            #   if not => add that value to the array list, along with its left and right nodes to the queue
            nodes.append(currentNode.val)
            queue.append(currentNode.left)
            queue.append(currentNode.right)

        # return the array list
        return nodes

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        #   edge case checks
        if (data == None or len(data) == 0 or data == [None]):
            return None

        #   initializations
        queue = deque([])
        root = TreeNode(data[0])
        queue.append(root)
        cursor = 1

        #   iterate until the queue is empty
        while (len(queue) > 0):

            #   remove the front node
            currentNode = queue.popleft()

            #   add its corresponding left node
            if (data[cursor] != None):
                currentNode.left = TreeNode(data[cursor])
                queue.append(currentNode.left)
            cursor += 1

            #   add its corresponding right node
            if (data[cursor] != None):
                currentNode.right = TreeNode(data[cursor])
                queue.append(currentNode.right)
            cursor += 1

        #   return root node
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))