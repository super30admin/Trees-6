# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
from collections import deque

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root: return ""
        result = ""
        
        queue = deque([root])
        while queue:
            node = queue.popleft()
            if node:
                result+= str(node.val)+","
                queue.append(node.left)
                queue.append(node.right)
            else:
                result+="null,"
        return str(result)
                
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return 
        data = data.split(",")
        nullCounts = 0
        parentIdx = 0
        root = TreeNode(int(data[0]))
        queue = deque([root])
        
        while (2*(parentIdx-nullCounts)+2) < len(data) and queue:
            # fetch the current node from the queue.
            node = queue.popleft()
            
            if data[parentIdx] != "null":
                """
                Find the child nodes:
                
                left child - 2*parent_node + 1
                right child - 2*parent_node + 2
                """
                leftChild = 2*(parentIdx-nullCounts)+1
                rightChild = 2*(parentIdx-nullCounts)+2
                
                # process the left child
                if data[leftChild]!="null":
                    node.left = TreeNode(int(data[leftChild]))  
                queue.append(node.left)
                
                # process the right child
                if data[rightChild]!="null":
                    node.right = TreeNode(int(data[rightChild]))  
                queue.append(node.right)
                    
            else:   # keep track of nulls before the current node.
                nullCounts += 1
                
            # increment the parent index
            parentIdx+=1
        
        return root
        


# Method 2
# without keeping track of left and right child indices.
# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
from collections import deque
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root: return ""
        result = ""
        
        queue = deque([root])
        while queue:
            node = queue.popleft()
            if node:
                result+= str(node.val)+","
                queue.append(node.left)
                queue.append(node.right)
            else:
                result+="null,"
        
        return str(result)
                
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return 
        
        data = data.split(",")[:-1]
        idx = 1
        root = TreeNode(int(data[0]))
        queue = deque([root])
        
        while idx < len(data) and queue:
            # pop the node from the queue
            node = queue.popleft()
            
            # process the left child
            if data[idx] != "null":
                node.left = TreeNode(int(data[idx]))
                queue.append(node.left)     # append the left child to the queue
                
            # process the right child
            if data[idx+1] != "null":
                node.right = TreeNode(int(data[idx+1]))  
                queue.append(node.right)    # append the right child to the queue
            
            idx+=2
        
        return root
            
            
# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))