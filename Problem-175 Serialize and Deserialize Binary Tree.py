# 297. Serialize and Deserialize Binary Tree
# https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Codec:

    def serialize(self, root):
        # Logic: We do a modified Level order traversal or BFS. 
        # If the node is None, we add None to the serialized 
        # string otherwise add the node.val in serial string 
        # and just add the left and right child to the queue 
        # without none check.

        # Time Complexity: O(n)
        # Space Complexity: O(n)

        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "None"
        
        s = []
        q = deque()
        q.append(root)
        
        while q:
            node = q.popleft()
            
            if node == None:
                s.append("None")
            else:
                s.append(str(node.val))
                
                q.append(node.left)
                q.append(node.right)

        return ",".join(s)

    def deserialize(self, data):
        # Logic: We use a queue (treenode as elements) and a pointer (i). 
        # We run till the q is not empty or the pointer ruhs out of index. 
        # If the node coming out of the q is not null we take i+1 and i+2 
        # elemnt and add them as the left and right child. If it is null, 
        # we dont move the i pointer just pop it out of the q. 

        # Time Complexity: O(n)
        # Space Complexity: O(n)

        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "None":
            return []
        
        splitData = data.split(",")
        i = 0
        # Type: TreeNode
        q = deque()
        root = TreeNode(splitData[i])
        q.append(root)
        i += 1

        while q and i < len(splitData) - 1:
            cur = q.popleft()

            if cur:
                # Fill Left child
                if splitData[i] != "None":
                    leftChild = TreeNode(splitData[i])
                    cur.left = leftChild
                q.append(cur.left)
                i += 1

                # Fill Left child
                if splitData[i] != "None":
                    rightChild = TreeNode(splitData[i])
                    cur.right = rightChild
                q.append(cur.right)
                i += 1
        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))