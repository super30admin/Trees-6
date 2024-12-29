#Approach
#Use the level order traversal to make the encoded string
# use the queue in the decoding to map node with the children


#Complexities
#Time: o(n)
#Space:o(n)

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        queue = [root]
        encode = []
        while queue:
            popNode = queue.pop(0)
            if popNode:
                encode.append(str(popNode.val))
                queue.append(popNode.left)
                queue.append(popNode.right)
            else:
                encode += "#"

        return ",".join(encode)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        if not data or data[0] == "#":
            return None
        data = data.split(",")
        root = TreeNode(data[0])
        index = 1
        queue = [root]

        while queue:
            node = queue.pop(0)
            if data[index] != "#":
                node.left = TreeNode(int(data[index]))
                queue.append(node.left)
            index += 1
            if data[index] != "#":
                node.right = TreeNode(int(data[index]))
                queue.append(node.right)
            index += 1
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))