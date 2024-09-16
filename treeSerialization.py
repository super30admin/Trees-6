# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    '''
    # bfs solution
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if(root==None):
            return
        data_list = [str(root.val)]
        q = deque([root])
        while(len(q)>0):
            e = q.popleft()
            if(e.left!=None):
                q.append(e.left)
                data_list.append(str(e.left.val))
            else:
                data_list.append("null")
            if(e.right!=None):
                q.append(e.right)
                data_list.append(str(e.right.val))
            else:
                data_list.append("null")
        return ",".join(data_list)
                
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if(data==None or len(data)==0):
            return 
        data_list = data.split(',')
        root = TreeNode(data_list[0])
        q = deque([root])
        i=0
        while(len(q)>0):
            node = q.popleft()
            i+=1
            if(i<len(data_list) and data_list[i]!="null"):
                node.left = TreeNode(data_list[i])
                q.append(node.left)
            i+=1 
            if(i<len(data_list) and data_list[i]!="null"):
                node.right = TreeNode(data_list[i])
                q.append(node.right)
        return root
    '''
    
    # DFS traversal
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def dfs(root):
            if not root:
                res.append("None,")
                return 
            res.append(str(root.val)+",")
            dfs(root.left)
            dfs(root.right)
            
        res = []
        dfs(root)
        return "".join(res)
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        def rdeserialize(l):
            """ a recursive helper function for deserialization."""
            if l[0] == 'None':
                l.pop(0)
                return None
                
            root = TreeNode(l[0])
            l.pop(0)
            root.left = rdeserialize(l)
            root.right = rdeserialize(l)
            return root

        data_list = data.split(',')
        root = rdeserialize(data_list)
        return root
            
