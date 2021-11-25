# # Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    TC: O(n)
    SC: O(n)

"""

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.



        :type root: TreeNode
        :rtype: str
        """

        ### we can do DFs preorder traversal to serialize the tree
        def preorder(root, string):
            if root == None:
                string += "None,"
            else:
                string += str(root.val) + ","
                ##root here is not none so we go for the left and right
                ###child
                string = preorder(root.left, string)
                string = preorder(root.right, string)

            return string

        return preorder(root, "")

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        def helper(datalist):
            # print(datalist)
            if datalist[0] == 'None':
                datalist.pop(0)
                return None

            root = TreeNode(datalist[0])  ###assigning datalist[0] to root

            datalist.pop(0)
            ##now assign values to root.left and root.right
            root.left = helper(datalist)
            root.right = helper(datalist)
            return root

        datalist = data.split(",")
        root = helper(datalist)
        return root

        ##we always have to return root after making tree

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))