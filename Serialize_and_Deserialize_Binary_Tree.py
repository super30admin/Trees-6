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
        
        q = deque()        
        q.append(root)
        result = ""
        while q:
            node = q.popleft()
            if node:
                result += str(node.val)
                result += ","
                q.append(node.left)
                q.append(node.right)
                
            else:
                result += "null"
                result += ","

        #print(result)
        return result    
            
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        
        tree = data.split(",")
        #print(tree)        
        q = deque()
        root = TreeNode(tree[0])
        q.append(root)
        i = 1
        while q and i < len(tree):
            node = q.popleft()
            if tree[i] != "null":
                node.left = TreeNode(tree[i])
                q.append(node.left)
            i+=1
            if tree[i] != "null":
                node.right = TreeNode(tree[i])
                q.append(node.right)
            i+=1
          
        return root
        
        
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
