# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

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
        q=[]
        q.append(root)
        s=""
        while q:
            curr=q.pop(0)
            if curr== None :
                s=s+'None'+','
            else:
                s=s+str(curr.val)+','
            if curr:
                q.append(curr.left)
                q.append(curr.right)
        return s.rstrip(',')
                
            
            
            
            
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data is '':
            return []
        data=data.split(',')
        print(data)
        q=[]
        root=TreeNode(data[0])
        q.append(root)
        i=1
        
        
        while q and i<len(data):
            print("x",i)
            curr=q.pop(0)
            if data[i] != 'None':
                curr.left=TreeNode(data[i])
                q.append(curr.left)
            i+=1
            if data[i] != 'None':
                curr.right=TreeNode(data[i])
                q.append(curr.right)
            i+=1

        return root
            
            
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))