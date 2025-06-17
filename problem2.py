# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)

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
        res = []
        queue = collections.deque()
        queue.append(root)

        while queue:
            cur = queue.popleft()
            if cur:
                res.append(str(cur.val))
                queue.append(cur.left)
                queue.append(cur.right)
            else:
                res.append("null")

        res = "#".join(res)
        print(res)
        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data = data.split("#")

        i = 0
        if data[i] == "null":
            return None

        root = TreeNode(int(data[i]))
        i += 1

        queue = collections.deque()
        queue.append(root)
        while queue and i < len(data):
            cur = queue.popleft()
            # make left
            if data[i] != "null":
                left_node = TreeNode(int(data[i]))
                cur.left = left_node
                queue.append(left_node)
            i += 1

            # make right
            if data[i] != "null":
                right_node = TreeNode(int(data[i]))
                cur.right = right_node
                queue.append(right_node)
            i += 1

        return root