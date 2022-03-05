# Time complexity: O(n) where n is the number of Nodes
# Space complexity : O(n)



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

        queue = []
        _str = ""

        queue.append(root)

        while queue:
            elem = queue.pop(0)
            if elem is None:
                _str = _str + "None,"
            else:
                _str = _str + str(elem.val)+","

            if elem is not None:
                queue.append(elem.left)
                queue.append(elem.right)


        return _str



    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data is None or len(data) == 0:
            return None

        arrStr = data.split(",")

        i = 1

        queue= []
        root = TreeNode(int(arrStr[0]))
        queue.append(root)

        while queue:
            elem = queue.pop(0)
            if arrStr[i] != "None":
                newNode = TreeNode(int(arrStr[i]))
                elem.left = newNode
                queue.append(newNode)

            i+= 1

            if arrStr[i] != "None":
                newNode = TreeNode(int(arrStr[i]))
                elem.right = newNode
                queue.append(newNode)

            i+= 1

        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))