# Approach:
# - We use level-order traversal (BFS) for serialization, storing 'null' for missing nodes.
# - For deserialization, we reconstruct the tree using a queue.
# Time Complexity: O(N) for both serialization and deserialization.
# Space Complexity: O(N) for storing serialized data and the queue.

# Definition for a binary tree node.
class Codec:
    
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "null"  # Return null for an empty tree
        
        queue = [root]  # BFS queue
        res = []  # Store serialized values
        
        while queue:
            node = queue.pop(0)
            if node:
                res.append(str(node.val))  # Store node value
                queue.append(node.left)  # Enqueue left child
                queue.append(node.right)  # Enqueue right child
            else:
                res.append("null")  # Mark null for missing nodes
        
        return ",".join(res)  # Convert list to a single string

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "null":
            return None  # Handle empty tree case
        
        nodes = data.split(",")  # Split data into a list
        root = TreeNode(int(nodes[0]))  # Create root node
        queue = [root]  # BFS queue
        i = 1  # Index to track node position
        
        while queue and i < len(nodes):
            node = queue.pop(0)  # Dequeue a node
            
            if nodes[i] != "null":  # If valid, create left child
                node.left = TreeNode(int(nodes[i]))
                queue.append(node.left)  # Enqueue left child
            i += 1
            
            if i < len(nodes) and nodes[i] != "null":  # If valid, create right child
                node.right = TreeNode(int(nodes[i]))
                queue.append(node.right)  # Enqueue right child
            i += 1
        
        return root  # Return reconstructed tree

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))