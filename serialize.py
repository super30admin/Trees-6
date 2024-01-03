# Time: O(n)
# Space: O(n)
# Did it run on Leetcode: yes

# # Definition for a binary tree node.
# # class TreeNode(object):
# #     def __init__(self, x):
# #         self.val = x
# #         self.left = None
# #         self.right = None
# from Queue import Queue
# class Codec:
#     # sb=[]
#     def serialize(self, root):
#         """Encodes a tree to a single string.
        
#         :type root: TreeNode
#         :rtype: str
#         """
#         # bfs code: O(n)
#         # if not root:
#         #     return ""
#         # res=[]
#         # q=Queue()
#         # q.put(root)
#         # res.append(str(root.val))
        
#         # while not q.empty():
#         #     curr=q.get()
#         #     # res.append(",")
#         #     if(curr.left!=None):
#         #         q.put(curr.left)
#         #         res.append(str(curr.left.val))
#         #     else:
#         #         res.append("#")
#         #     # res.append(",")
#         #     if(curr.right!=None):
#         #         q.put(curr.right)
#         #         res.append(str(curr.right.val))
#         #     else:
#         #         res.append("#")
            
#         # print(res)
#         # return ",".join(res)
        
#         sb=[]
#         def serilaizehelper(root,sb):
#             if root is None:
#                 sb.append('#')
#                 return
#             sb.append(str(root.val))
#             serilaizehelper(root.left,sb)
#             serilaizehelper(root.right, sb)
#         serilaizehelper(root,sb)
#         return ",".join(sb)
    
#     idx=1
#     def deserialize(self, data):
#         """Decodes your encoded data to tree.
        
#         :type data: str
#         :rtype: TreeNode
#         """
#         # if(data==""):
#         #     return None
#         # strar=data.split(",")
#         # q = Queue()
#         # root=TreeNode(int(strar[0]))
#         # q.put(root)
#         # idx=1
#         # while not q.empty():
#         #     curr=q.get()
#         #     # left child:
#         #     if(strar[idx]!='#'):
#         #         curr.left=TreeNode(int(strar[idx]))
#         #         q.put(curr.left)
#         #     idx+=1
#         #     # right child":
#         #     if(strar[idx]!='#'):
#         #         curr.right=TreeNode(int(strar[idx]))
#         #         q.put(curr.right)
#         #     idx+=1
#         # return root

#         if(data==""):
#             return None
#         strarr=data.split(",")
#         root=TreeNode(int(strarr[0]))
#         def deserializehelper(root):
#             # base
#             if(root is None):
#                 return
            
#             # logic
#             if(strarr[self.idx]!="#"):
#                 root.left=TreeNode(int(strarr[self.idx]))
            
#             self.idx+=1
#             deserializehelper(root.left)
#             if(strarr[self.idx]!="#"):
#                 root.right=TreeNode(int(strarr[self.idx]))
#             self.idx+=1
#             deserializehelper(root.right)


#         deserializehelper(root)
#         return root

        

# # Your Codec object will be instantiated and called as such:
# # ser = Codec()
# # deser = Codec()
# # ans = deser.deserialize(ser.serialize(root))



from Queue import Queue

# class TreeNode:
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
        sb = []

        def serialize_helper(node, sb):
            if node is None:
                sb.append('#')
            else:
                sb.append(str(node.val))
                serialize_helper(node.left, sb)
                serialize_helper(node.right, sb)

        serialize_helper(root, sb)
        return ",".join(sb)
    # idx=0
    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        self.idx=0
        str_arr = data.split(",")
        root = self.deserialize_helper(str_arr)
        return root

    def deserialize_helper(self, str_arr):
        if self.idx >= len(str_arr) or str_arr[self.idx] == '#':
            self.idx += 1
            return None

        root = TreeNode(int(str_arr[self.idx]))
        self.idx += 1
        root.left = self.deserialize_helper(str_arr)
        self.idx += 1
        root.right = self.deserialize_helper(str_arr)

        return root
