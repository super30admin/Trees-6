Approach 1:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
for serialising a tree, we used DFS and stored the values in a list.
For deserializing a tree, we used the above created list and traversed through the list and created the tree using DFS.
Time complexity -->o(n)
space complexity -->o(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Codec:
    def dfs(self,root,list1):
        if root==None:
            list1.append('null')
            return
        else:
            list1.append(root.val)
        self.dfs(root.left,list1)
        self.dfs(root.right,list1)
        return list1
    
    def dfs1(self,data,cursor):
        if data[cursor]=='null':
            # cursor=cursor+1
            return None
        root=TreeNode(data[cursor])
        root.left=self.dfs1(data,cursor+1)
        root.right=self.dfs1(data,cursor+1)
        return root
 
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        return(self.dfs(root,[]))

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        print(data)
        if data==None:
            return None
        return self.dfs1(data,0)

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))

Approach 2:
using BFS.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we used BFS approach and using queue and stored the values by concatenating the node values with , delimiter.
for deserializing we used , as delimiter and used the values generated and used BFS to create the tree.



Time complexity -->o(n)
space complexity -->o(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root==None :
            return ''
        queue=deque([root])
        str1=''
        while len(queue)!=0:
            node=queue.popleft()
            #concatenating all the values in the tree to make a string.
            if node==None:
                str1=str1+'null,'
                continue
            str1=str1+str(node.val)+','
            queue.append(node.left)
            queue.append(node.right)
        # print(str1)
        return str1
        
            
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data=='':
            return None
        #split the string into values.
        vallist=data.split(',')
        root=TreeNode(int(vallist[0]))
        queue=deque([root])
        cursor=1
        while len(queue)!=0:
            current=queue.popleft()
            #If the value is not null then we create a treenode using the given value.
            if vallist[cursor]!='null':
                current.left=TreeNode(int(vallist[cursor]))
                queue.append(current.left)
            cursor=cursor+1
            if vallist[cursor]!='null':
                current.right=TreeNode(int(vallist[cursor]))
                queue.append(current.right)
            cursor=cursor+1
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))