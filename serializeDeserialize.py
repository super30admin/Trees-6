
#Time Complexity: O(n)
#Space Complexity: O(n)
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return ""
        q = deque()
        q.append(root)
        res = []
        res.append(str(root.val))
        
        while q:
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
                res.append(str(curr.left.val))
            else:
                res.append("null")
                
            if curr.right:
                q.append(curr.right)
                res.append(str(curr.right.val))
            else:
                res.append("null")
     
        return ",".join(res)
                
        
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        if len(data) == 0:
            return None
        lst = []
        lst = data.split(',')
      
        root = TreeNode(lst[0])
        q = deque()
        q.append(root)
        i = 0
        while q:
            curr = q.popleft()
            i = i+1
            
            if i<len(lst) and lst[i] != "null":
                node = TreeNode(lst[i])
                q.append(node)
                curr.left = node
                
            i = i+1
            
            if i<len(lst) and lst[i] != "null":
                node = TreeNode(lst[i])
                q.append(node)
                curr.right = node
        
        return root
            
            
                
            
        