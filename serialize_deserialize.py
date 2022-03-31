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
            return ""
        q = []
        q.append(root)
        r = ""
        while q:
            curr = q.pop(0)
            if curr == "Null":
                r += "Null"
                r += ","
            else:
                r += str(curr.val)
                r += ","
                if curr.left:
                    q.append(curr.left)
                else:
                    q.append("Null")
                if curr.right:
                    q.append(curr.right)
                else:
                    q.append("Null")
        return r

    def deserialize(self, data):
        if not data  or len(data) == 0 :
            return None 
        s = data.split(",")
        root_val = int(s[0])
        idx = 1
        q = []
        root = TreeNode(root_val)
        q.append(root)
        while q and idx < len(s):
            curr = q.pop(0)
            if not s[idx] == "Null":
                curr.left = TreeNode(s[idx])
                q.append(curr.left)
            idx += 1

            if not s[idx] == "Null":
                curr.right = TreeNode(s[idx])
                q.append( curr.right )
            idx += 1
        return root
        
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
