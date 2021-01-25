#Time Complexity : O(N)
#Space Complexity : O(N) 
#Did this code successfully run on Leetcode : Yes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        def helper(root, string):
            if root is None:
                string += "X,"
            else:
                string += str(root.val) + ","
                string = helper(root.left, string)
                string = helper(root.right, string)
            return string

        return helper(root, '')


    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def helper(queue):

            if queue[0] == "X":
                queue.pop(0)
                return None

            newNode = TreeNode(queue[0])
            queue.pop(0)
            newNode.left = helper(queue)
            newNode.right = helper(queue)
            return newNode

        queue = data.split(",")
        newNode = helper(queue)
        return newNode




# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
