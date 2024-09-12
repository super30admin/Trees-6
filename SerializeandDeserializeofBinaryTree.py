# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''

        def levelOrder(root):
            res = []
            queue = [root]
            while queue:
                for i in range(len(queue)):
                    node = queue.pop(0)
                    if node:
                        res.append(str(node.val))
                        queue.append(node.left)
                        queue.append(node.right)
                    else:
                        res.append('Null')

            return res

        output = levelOrder(root)

        return ' '.join(output)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 0:
            return None
        data = data.split()
        root = TreeNode(int(data[0]))
        queue = [root]
        i = 1
        while queue and i < len(data):
            node = queue.pop(0)
            if data[i] != "Null":
                node.left = TreeNode(int(data[i]))
                queue.append(node.left)
            i += 1
            if data[i] != "Null":
                node.right = TreeNode(int(data[i]))
                queue.append(node.right)
            i += 1
        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))