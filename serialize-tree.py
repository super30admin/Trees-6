# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)
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
        # Preorder traversal
        if not root:
            return []
        # Use a dequeue to store traversal - more efficiant to pop from fron while deserializing
        preorder = collections.deque()

        def helper(node):
            preorder.append(node.val)
            if node.left is not None:
                helper(node.left)
            else:  # Append null if left or right child is not present
                preorder.append(None)
            if node.right is not None:
                helper(node.right)
            else:
                preorder.append(None)
        helper(root)
        return preorder

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        # Recursively build the tree from the preorder traversal
        if len(data) == 0:
            return None

        def helper(q):
            # Base case
            if len(q) == 0:
                return None

            val = q.popleft()
            if val is None:
                return
            else:
                # Create a new treenode from popped value
                root = TreeNode(val)
                # Recursively create the left and right subtrees
                root.left = helper(q)
                root.right = helper(q)
                return root
        return helper(data)


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
