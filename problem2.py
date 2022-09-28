class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res=""
        q=deque()
        q.append(root)
        
        while q:
            cur=q.popleft()
            
            if cur is None:
                res+=str(None)
            else:
                res+=str(cur.val)
                
            res+=","
            
            if cur:
                q.append(cur.left)
                q.append(cur.right)
        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data is None:
            return None
        q=deque()
        s=data.split(",")
        if s[0] == "None":
            return None
        root = TreeNode(int(s[0]))
        q.append(root)
        i=1
        while q:
            cur = q.popleft()
            
            if cur:
                if s[i]!="None":
                    cur.left = TreeNode(int(s[i]))
                q.append(cur.left)
                i+=1
                if s[i]!="None":
                    cur.right = TreeNode(int(s[i]))
                q.append(cur.right)
                i+=1
                
        return root
