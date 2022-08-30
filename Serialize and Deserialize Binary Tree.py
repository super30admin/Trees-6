""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""



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
        if not root:
            return ''
        result = []

        q = deque()
        q.append(root)

        while q:
            curr = q.popleft()

            if curr:
                result.append(str(curr.val))
                result.append(',')
            elif not curr:
                result.append('null')
                result.append(',')
            if curr:
                q.append(curr.left)
                q.append(curr.right)
        result.pop()

        return ''.join(result)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 0:
            return

        data = data.split(',')
        root = TreeNode(data[0])
        q = deque()
        q.append(root)
        idx = 0

        while q:
            curr = q.popleft()
            idx += 1
            if data[idx] != 'null':
                temp = TreeNode(data[idx])
                curr.left = temp
                q.append(temp)
            idx += 1
            if data[idx] != 'null':
                temp = TreeNode(data[idx])
                curr.right = temp
                q.append(temp)
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))



# class Codec:
#     def serialize(self, root):
#         res = []
#
#         def dfs(node):
#             if not node:
#                 res.append("N")
#                 return
#             res.append(str(node.val))
#             dfs(node.left)
#             dfs(node.right)
#
#         dfs(root)
#         print(res)
#         return ",".join(res)
#
#     def deserialize(self, data):
#         """Decodes your encoded data to tree.
#
#         :type data: str
#         :rtype: TreeNode
#         """
#         vals = data.split(',')
#         self.i = 0  # to keep track on index
#
#         def dfs():
#             if vals[self.i] == "N":
#                 self.i += 1
#                 return None
#             node = TreeNode(int(vals[self.i]))
#             self.i += 1
#             node.left = dfs()
#             node.right = dfs()
#
#             return node
#
#         return dfs()