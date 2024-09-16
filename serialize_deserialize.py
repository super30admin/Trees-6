# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#Time Complexity: O(N)

#Space Complexity: O(N) 

from collections import deque
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        destring = []
        queue = deque()
        queue.append(root)
        destring.append(str(root.val))
        
        while(queue):
            node = queue.popleft()
            if node.left :
                destring.append(str(node.left.val))
                queue.append(node.left)
            else:
                destring.append('null')
            
            if node.right:
                destring.append(str(node.right.val))
                queue.append(node.right)
            else:
                destring.append('null')
        
        return (','.join(destring))

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        if not data or len(data)==0:
            return []
        dlist = data.split(',')
        
        q = deque()
        root = TreeNode(dlist[0])
        q.append(root)
        
        i =1
        while(q):
            sz = len(q)
            for ind in range(sz):
                node = q.popleft()
              
                if dlist[i] !='null':
                    left = TreeNode(int(dlist[i]))
                    node.left = left
                    q.append(left)
                    
                
                i+=1
               
                if dlist[i]!='null':
                    right = TreeNode(int(dlist[i]))
                    node.right = right
                    q.append(right)
                    
               
                i+=1
        
        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))