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
        # using the BFS

        if root is None: return ""
        result = ''
        queue = collections.deque()
        queue.append(root)

        while (queue.__len__() > 0):
            size = queue.__len__()

            for idx in range(size):
                root = queue.popleft()
                if root is None:
                    result += "null"
                    result += ","
                else:
                    result += str(root.val)
                    result += ","
                    queue.append(root.left)
                    queue.append(root.right)

        return result

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        #         if not data:
        #             return None

        #         tree = data.split(",")
        #         #print(tree)
        #         q = deque()
        #         root = TreeNode(tree[0])
        #         q.append(root)
        #         i = 1
        #         while q and i < len(tree):
        #             node = q.popleft()
        #             if tree[i] != "null":
        #                 node.left = TreeNode(tree[i])
        #                 q.append(node.left)
        #             i+=1
        #             if tree[i] != "null":
        #                 node.right = TreeNode(tree[i])
        #                 q.append(node.right)
        #             i+=1

        # using the BFS

        if data is None or len(data) == 0: return []
        index = 0
        tree = data.split(',')

        root = TreeNode(tree[index])

        queue = collections.deque()
        queue.append(root)

        while queue.__len__() > 0 and index < len(tree):
            # size = queue.__len__()

            Node = queue.popleft()
            index += 1
            if tree[index] != "null":
                Node.left = TreeNode(tree[index])
                queue.append(Node.left)
            index += 1

            if tree[index] != "null":
                Node.right = TreeNode(tree[index])
                queue.append(Node.right)
        return root

    # Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))