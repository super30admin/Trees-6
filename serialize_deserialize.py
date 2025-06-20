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

        if root is None:
            return ""

        ## First I will follow the BFS Queue approach to find all the roots and form a string

        queue = deque()
        queue.append(root)
        stack = []
        while queue:
            curr_root = queue.popleft()

            if curr_root != None:
                stack.append(curr_root.val)
                if curr_root.left:
                    queue.append(curr_root.left)
                else:
                    queue.append(None)

                if curr_root.right:
                    queue.append(curr_root.right)
                else:
                    queue.append(None)
            else:
                stack.append("#")

        s = ""
        for i in stack:
            s = s + str(i)
            s = s + ","
        return s

    def deserialize(self, data):

        if data is "":
            return []

        nodes_data = data

        nodes_data = data.split(",")

        # I am gonna follow the bfs approach using queue to construct the tree again
        index = 0
        queue = deque()

        root = TreeNode(int(nodes_data[index]))

        queue.append(root)
        index += 1

        while queue:
            curr_node = queue.popleft()

            if nodes_data[index] != "#":
                curr_node.left = TreeNode(int(nodes_data[index]))
                index += 1
                queue.append(curr_node.left)
            else:
                curr_node.left = None
                index += 1

            if nodes_data[index] != "#":
                curr_node.right = TreeNode(int(nodes_data[index]))
                index += 1
                queue.append(curr_node.right)
            else:
                curr_node.right = None
                index += 1

        # while(root):
        #     if root.right:
        #         print(root.right.val)
        #     root=root.right
        return root
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))


'''
Time complexity: O(n), In both serialization and deserialization, we visit each node exactly once.
Space complexity: O(n), The space complexity is O(n), which is nothing but the queue used for BFS traversal in both serialization and deserialization.
'''
