# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Time - O(N)
# Space - O(N)

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = []
        
        if not root:
            return result
        
        q = deque()
        q.append(root)
        
        while q:
            
            current_node = q.popleft()
            
            if current_node:
                # if not a null node
                result.append(str(current_node.val))
                # result.append(',') # not needed for list but string builder
                
                # add left right children to queue not result, no need to check for null
                q.append(current_node.left)
                q.append(current_node.right)
                
            else:
                # if null node, simply add to result, do not check for children
                result.append('null')
                # result.append(',')
                
        return result
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        # result string from above is fed to this function
        
        if not data:
            return None
        
        # data.split(',')
        q = deque()
        i = 0
        
        # construct root node with 0th index val from data
        root_node = TreeNode(int(data[i]))
        q.append(root_node)
        
        # increment i to point next index which is left child of root node
        i += 1
        
        # as long as q is not empty and i does not breach
        while q and i < len(data):
            current_node = q.popleft()
            
            # now construct left child of current node (i + 1 position)
            if data[i] != 'null':
                current_node.left = TreeNode(int(data[i]))
                q.append(current_node.left)
                
            i += 1 # whether it was null or not inc i to next -- so that when we pop next we can use this location node as children
            
            # now construct right child (ie at i + 2 position)
            
            if data[i] != 'null':
                current_node.right = TreeNode(int(data[i]))
                q.append(current_node.right)
                
            i += 1 # similar to above inc it to next one -- so that when we pop next we can use this location node as children
        
        
        return root_node

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))