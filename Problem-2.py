# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        s=[]
        def encode(node,s):
            if not node:
                s.append('#')
                return
            
            s.append(str(node.val))
            encode(node.left,s)
            encode(node.right,s)
            
        encode(root,s)
        return ''.join(s)
    
        

    def deserialize(self, data): 
        print(data)
        def stringToList(data):
            res=[]
            i=0
            while i<len(data):
                if data[i]=='-':
                    temp=data[i]
                    i+=1
                    temp=temp+data[i]
                    res.append(temp)
                else:
                    res.append(data[i])
                i+=1
            return res
        vals=stringToList(data)
        def decode(vals):
            if vals[0]=='#':
                vals.pop(0)
                return None
            
            node=TreeNode((vals.pop(0)))
            # vals.pop(0)
            node.left=decode(vals)
            node.right=decode(vals)
            return node
            
                
        return decode(vals)
    