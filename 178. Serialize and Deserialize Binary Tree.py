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
        sb = list()
        if root is None:
            return "".join(sb)
        q = deque()
        q.append(root)

        while q:
            curr = q.popleft()
            if not curr:
                sb.append(None)
            else:
                sb.append(curr.val)
            sb.append(",")

            if curr:
                q.append(curr.left)
                q.append(curr.right)
        # print("".join(map(str, sb)))
        return "".join(map(str, sb))

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data is None or len(data) == 0:
            return []
        strArray = data.split(",")
        q = deque()
        i = 1
        root = TreeNode(int(strArray[0]))
        q.append(root)

        while q and i < len(strArray):
            curr = q.popleft()

            if strArray[i] != "None":
                curr.left = TreeNode(int(strArray[i]))
                q.append(curr.left)
            i += 1

            if strArray[i] != "None":
                curr.right = TreeNode(int(strArray[i]))
                q.append(curr.right)
            i += 1
        return root

# BFS
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No