# Approach: DFS preorder

# TC: O(N), SC:O(N)


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def __init__(self):
        self.sb = ""
        global i
        i = 0
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        # If we don't have tree to serialize then return empty string
        if not root: return ""
        self.dfs(root)
        print(str(self.sb))
        return self.sb

    def dfs(self, root):
        if not root: 
            self.sb+= "#"
            self.sb+= ","
            return
        else:
            self.sb+= str(root.val)
            self.sb+= ","
            self.dfs(root.left)
            self.dfs(root.right)
        
    
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data: return None
        strArr = data.split(",")
        root = TreeNode(int(strArr[0]))
        global i
        i+=1
        self.helper(root, strArr)
        return root 

    def helper(self, root, strArr):
        global i
        if i == len(strArr): return
        if not root: return
        # left
        if strArr[i] != "#":
            root.left = TreeNode(int(strArr[i]))
        i+=1
        self.helper(root.left, strArr)
        # right
        if strArr[i] != "#":
            root.right = TreeNode(int(strArr[i]))
        i+=1
        self.helper(root.right, strArr)

        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))