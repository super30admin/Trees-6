"""
Time Complexity : O(n) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""
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
        q = deque()
        q.append(root)
        result = []
        while q:
            curr = q.popleft()
            if curr:
                result.append(str(curr.val))
                result.append(",")
                q.append(curr.left)
                q.append(curr.right)
            else:
                result.append("null")
                result.append(",")
        return ''.join(result)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        arr = data.split(',')
        root = TreeNode(int(arr[0]))
        q = deque()
        q.append(root)
        i = 1
        while q and i < len(arr):
            curr = q.popleft()
            if arr[i] != 'null':
                left = TreeNode(arr[i])
                curr.left = left
                q.append(left)
            i += 1
            if i < len(arr) and arr[i] != 'null':
                right = TreeNode(arr[i])
                curr.right = right
                q.append(right)
            i += 1
        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
