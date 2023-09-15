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

        Time complexity- O(N), N --> number of nodes in the binary tree
        Space complexity- O(N) due to the recursion stack and the queue used for deserialization.
        """
        def dfs(node):
            if not node:
                return "null"
            left_str = dfs(node.left)
            right_str = dfs(node.right)
            return str(node.val) + "," + left_str + "," + right_str
        return dfs(root)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        values = data.split(',')
        queue = collections.deque(values)

        def build_tree():
            if not queue:
                return None

            val = queue.popleft()
            if val == "null":
                return None

            node = TreeNode(int(val))
            node.left = build_tree()
            node.right = build_tree()
            return node

        return build_tree()


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
