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
        result = []
        if root == None:
            return ""
        que1 = deque()
        que1.append(root)
        while que1 :
            curr = que1.popleft()
            if curr:
                result.append(str(curr.val))
                que1.append(curr.left)
                que1.append(curr.right)
            else:
                result.append("null")
        return ",".join(result)


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        nodes = data.split(',')
        que2 = deque()
        root = TreeNode(int(nodes[0]))
        que2.append(root)
        i = 1
        while que2 and i < len(nodes):
            curr = que2.popleft()
            if nodes[i] != "null":
                curr.left = TreeNode(int(nodes[i]))
                que2.append(curr.left)
            i += 1

            if i < len(nodes) and nodes[i] != "null":
                curr.right = TreeNode(int(nodes[i]))
                que2.append(curr.right)
            i += 1

        return root



                

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))

#TC : O(n)
# sc : O(n)