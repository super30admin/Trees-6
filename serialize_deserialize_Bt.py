# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# Time Complexity: O(n)
# Space Complexity: O(n)
class Codec:

    def serialize(self, root):

        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        return self.dfs(root, '')

    #     Here we will check if root is null we will append the same to result and if not
    #     we will append to result and we will call same function on left and right side of the tree

    def dfs(self, root, result):

        if root is None:
            result += 'None,'
        else:
            result += str(root.val) + ','
            result = self.dfs(root.left, result)
            result = self.dfs(root.right, result)

        return result

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        nodes = data.split(',')
        return self.dser(nodes)

    #     While deserializing the string we will first check if the first element in the string
    #     list is None and if we will pop it nad return None and it wont be having further
    #     children and if not None we will consider this as current node and we will pop it
    #     from the list and call same function on list to assign it to the current node left
    #     and right child and eventually return the node
    def dser(self, nodes):

        if nodes[0] == 'None':
            nodes.pop(0)
            return None

        node = TreeNode(nodes[0])
        nodes.pop(0)

        node.left = self.dser(nodes)
        node.right = self.dser(nodes)

        return node

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))