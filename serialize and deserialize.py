"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
we use the q here. we put the elements which are null in q but do not process it
we append it to the string

in deserialization we use queue. we maintain a index over the string and assign values as left and right as
we increase the index

"""

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None: return ""
        srl = ""
        q = deque()
        q.append(root)
        
        while q:
            cur = q.popleft()
            if cur==None:
                srl += "null, "
            else:
                srl += str(cur.val)
                srl += ", "
            if cur != None:
                q.append(cur.left)
            if cur != None:
                q.append(cur.right)
       
        return srl

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "": return None
        q = deque()
        index = 1
        ele = data.split(', ')
        node = TreeNode(ele[0])
        root = node
        q.append(node)
        
        while q and index<len(data):
            cur = q.popleft()
        # if cur != None:
            node = TreeNode(ele[index])
            if ele[index] != "null":
                node = TreeNode(ele[index])
                cur.left = node
                q.append(node)
            index+=1
            
            if ele[index]!="null":
                node = TreeNode(ele[index])
                cur.right = node
                q.append(node)
            index+=1

        return root
            
                
            
        
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))