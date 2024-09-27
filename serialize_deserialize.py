class Codec:

    def serialize(self, root):

        def dfs(root, string):
            if not root:
                return string + 'None,'
            string += str(root.val) + ','
            string = dfs(root.left, string)
            string = dfs(root.right, string)
            return string
        return dfs(root, '')[:-1]      
    
    def deserialize(self, data):
        def dfs(l):
            if(l[0] == "None"):
                l.pop(0)                
                return None
            root = TreeNode( l.pop(0) )
            root.left = dfs(l)
            root.right = dfs(l)
            return root
        return dfs( data.split(",") )
        
        
        #tc o(n)
        #sc o(n)
