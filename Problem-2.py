# Time Complexity : O(N)  # Each node is visited once during serialization and deserialization
# Space Complexity : O(N) # To store serialized data and recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Use preorder traversal to serialize the tree.
# Add "null" for missing nodes to preserve structure.
# During deserialization read values sequentially and rebuild the tree recursively.

class Codec:

    def serialize(self, root):
        res = []
        
        def dfs(node):
            if not node:
                res.append("null")
                return
            
            res.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)
        return ",".join(res)

    def deserialize(self, data):
        vals = data.split(",")
        self.i = 0
        
        def dfs():
            if vals[self.i] == "null":
                self.i += 1
                return None
            
            node = TreeNode(int(vals[self.i]))
            self.i += 1
            
            node.left = dfs()
            node.right = dfs()
            
            return node
        
        return dfs()