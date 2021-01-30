# Time:- O(n)
# Space:- O(n)

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
        # BFS to traverse and serialize the tree
        if not root:
            return ""
        q=collections.deque([])
        q.append(root)
        string=""
        while(q):
            ele=q.popleft()
            if ele=="null":
                string+=ele+" "
                continue
            else:
                string+=str(ele.val)+" "
            if ele.left:
                q.append(ele.left)
            else:
                q.append("null")
            if ele.right:
                q.append(ele.right)
            else:
                q.append("null")
        return string
                
            
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        # put it back by iterating on the nodes
        nodes=data.strip().split(" ")
        if nodes==[""]:
            return None
        nodes[0]=TreeNode(int(nodes[0]))
        i,j=0,1
        while(j<len(nodes)):
            if nodes[i]=="null":
                i+=1
                continue
            if j<len(nodes) and nodes[j]!="null":
                nodes[j]=TreeNode(int(nodes[j]))
                nodes[i].left=nodes[j]
            if j+1<len(nodes) and nodes[j+1]!="null":
                nodes[j+1]=TreeNode(int(nodes[j+1]))
                nodes[i].right=nodes[j+1]
            j+=2
            i+=1
        return nodes[0]
            
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))