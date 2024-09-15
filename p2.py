#time: O(n)
#Space: O(N)

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def serial(root,string):
            if not root:
                string+='None,'
            else:
                string+=str(root.val)+','
                string = serial(root.left,string)
                string = serial(root.right,string)
            
            return string
        return serial(root,'')


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def deserial(l):
            if l[0]=='None':
                l.pop(0)
                return None
            root = TreeNode(l[0])
            l.pop(0)
            root.left = deserial(l)
            root.right = deserial(l)
            return root
        
        data = data.split(',')
        root =  deserial(data)
        return root
