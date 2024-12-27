#Time Complexity: O(N), where N is the number of nodes in the tree, as both serialization and deserialization involve traversing each node once.
#Space Complexity: O(N), for storing the serialized string during serialization and the recursion stack during deserialization.
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = []
        def dfs(node):
            if(node==None):
                result.append("N")
                return
            result.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return ",".join(result)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        vals = data.split(",")
        self.i = 0
        def dfs():
            if(vals[self.i]=="N"):
                self.i+=1
                return
            node = TreeNode(int(vals[self.i]))
            self.i += 1
            node.left = dfs()
            node.right = dfs()
            return node
        return dfs()