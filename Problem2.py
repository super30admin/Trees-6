#Time Complexity: O(N)
#Space Complexity: O(N)

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
        if not root:
            return ''
        strr = ""
        queue = [root]
        while queue:
            node = queue.pop(0)
            if not node:
                strr += 'None,'
                continue
            strr += str(node.val) + ","
            queue.append(node.left)
            queue.append(node.right)
        return strr
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        listt = data.split(",")
        index = 1
        root = TreeNode(int(listt[0]))
        queue = [root]
        while queue and index < len(listt):
            node = queue.pop(0)
            if listt[index] != 'None':
                node.left = TreeNode(listt[index])
                queue.append(node.left)
            index +=1
            if listt[index] != 'None':
                node.right = TreeNode(listt[index])
                queue.append(node.right)
            index +=1
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))