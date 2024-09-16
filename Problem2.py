#Time complexity : O(n) for each function 
#Space complexity: O(n) for each function 
#Works on leetcode : yes
#Approach : To serialize, we convert any Null to # and return tuples of 3 - root, root.left, root.right for a preorder traversal.
#For deserialization, we return None for # and otherwise create a tree recursively by recreating the tree nodes from the 
#serialized preorder data 

class Codec:

    def serialize(self, root):
        if not root:
            return '#'
        return root.val,self.serialize(root.left),self.serialize(root.right)
        

    def deserialize(self, data):
        if data[0]=='#':
            return None
        node = TreeNode(data[0])
        node.left = self.deserialize(data[1])
        node.right = self.deserialize(data[2])
        return node