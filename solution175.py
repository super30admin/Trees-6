#Time Complexity:O(n)
#Space Complexity:O(n)
#Approach:The serialize function uses a queue that stores the nodes of the given tree and serialize them into a string s, by concatinating
#the values of the node and None if the node doesnt exist. Deserialize function uses the string and takes the integer characters of string
#create root nodes and appends them into the queue while forming the tree connections. 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        s=''
        if root==None:
            return s
        q=deque()
        q.append(root)
        while q:
            curr=q.popleft()
            if curr:
                s+=str(curr.val)+','
                q.append(curr.left)
                q.append(curr.right)
            else:
                s+='None,'
        return s
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data)==0:
            return None
        q=deque()
        splitArray=data.split(',')
        root=TreeNode(int(splitArray[0]))
        q.append(root)
        i=1
        while q and i<len(splitArray):
            curr=q.popleft()
            if splitArray[i]!='None':
                curr.left=TreeNode(int(splitArray[i]))
                q.append(curr.left)
            i+=1
            if splitArray[i]!='None':
                curr.right=TreeNode(int(splitArray[i]))
                q.append(curr.right)
            i+=1
        return root
                
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))