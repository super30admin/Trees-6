# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    #Approach: DFS
    #Time Complexity: O(n)
    #Space Complexity: O(n)
    #where, n is the size of the tree
    
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        sb = []
        def helper(root):
            if not root:
                sb.append('None')
            else:
                sb.append(str(root.val))
                helper(root.left)
                helper(root.right)
        
        helper(root)
        print(','.join(sb))
        return ','.join(sb)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data = data.split(',')
        idx = 0
        def helper(data):
            nonlocal idx
            if data[idx] == 'None':
                idx += 1
                return None
            
            root = TreeNode(data[idx])
            idx += 1
            root.left = helper(data)
            root.right = helper(data)
            return root
            
        return helper(data)

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))