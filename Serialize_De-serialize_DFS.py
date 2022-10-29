# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        # check for null case and a default empty string to store the root values
        if not root:
            return ''
        self.string = ''
        
        # declaring the helper DFS function to make the list of preorder traversal
        def shelper(root):
            
            # if we encounter a null, then append a '#' to the string
            if not root:
                self.string += '#,'
                return
            # append the root val to the string
            self.string += str(root.val) + ','
            
            # recursively call the helper function on left and right side of the root
            shelper(root.left)
            shelper(root.right)
        
        # call the helper function and return the string
        shelper(root)
        return self.string
        

    # this function will convert a list to a Binary tree
    def deserialize(self, data):
        # check for null or empty case
        if not data or len(data) == 0:
            return None
        # split the data list by delimiter ','
        strArr = data.split(",")
        
        # idx is maintained for traversing through the strArr
        self.idx = 0
        
        # recursive function to form the tree with index as idx
        def dshelper(strArr):
            # if we encounter a '#', that means we have to add a null case, which is done by default, so just increment the idx and return
            if strArr[self.idx] == '#':
                self.idx += 1
                return
            
            # make the root as a new TreeNode with val from StrArr at idx
            root = TreeNode(strArr[self.idx])
            self.idx += 1
            
            # call the function recursively for left and right
            root.left = dshelper(strArr)
            root.right = dshelper(strArr)
            
            # return the root
            return root
        
        # call the helper function
        return dshelper(strArr)

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
