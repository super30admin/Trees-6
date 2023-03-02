# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def __init__(self):
        pass

    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        q = deque()
        string = ''
        q.append(root)
        while q:
            val = q.popleft()
            if not val:
                string += 'null' + ','
            else:
                string += str(val.val) + ','

            if val:
                if val.left:
                    q.append(val.left)
                else:
                    q.append(None)

                if val.right:
                    q.append(val.right)
                else:
                    q.append(None)

        return string[:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        splitarr = data.split(",")
        for i, val in enumerate(splitarr):
            splitarr[i] = TreeNode(val)

        root = splitarr[0]
        rootidx = 0
        idx = 1
        while idx < len(splitarr):
            splitarr[rootidx].left = splitarr[idx]
            idx += 1
            splitarr[rootidx].right = splitarr[idx]
            idx += 1
            rootidx += 1
        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
