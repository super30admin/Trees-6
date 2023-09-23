# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        def tree(node):
            if node:
                vals.append(str(node.val))
                tree(node.left)
                tree(node.right)
            else:
                vals.append('#')
        vals = []
        tree(root)
        return ' '.join(vals)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def tree():
            val = next(vals)
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = tree()
            node.right = tree()
            return node
        vals = iter(data.split())
        return tree()
        
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))