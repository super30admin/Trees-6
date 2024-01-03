# Time: O(n)
# Space: O(n)
# Did it run on Leetcode: yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from Queue import Queue
class Solution(object):
    # res=0
    def rangeSumBST(self, root, low, high):
    #     """
    #     :type root: TreeNode
    #     :type low: int
    #     :type high: int
    #     :rtype: int
    #     """
    #     # O(n)
    #     def dfs(root, low, high):
    #         # base
    #         if(root is None):
    #             return
    #         # logic
    #         if(root.val>=low and root.val<=high):
    #             self.res+=root.val
    #         dfs(root.left, low, high)
    #         dfs(root.right, low, high)
    #     dfs(root,low,high)
    #     return self.res
        
        # def dfs(root, low, high):
        #     # base
        #     if(root is None):
        #         return 0
        #     # logic
        #     res=0
        #     if(root.val>=low and root.val<=high):
        #         res+=root.val
        #     left=dfs(root.left, low, high)
        #     right=dfs(root.right, low, high)
        #     return res+left+right
        # return dfs(root,low,high)
        # return self.res

        # conditional dfs: O(n)
        # def dfs(root, low, high):
        #     # base
        #     if(root is None):
        #         return 0
        #     # logic
        #     res=0
        #     left, right=0,0
        #     if(root.val>=low and root.val<=high):
        #         res+=root.val
        #     if(root.val>low):
        #         left=dfs(root.left, low, high)
        #     if(root.val<high):
        #         right=dfs(root.right, low, high)
        #     return res+left+right
        # return dfs(root,low,high)
        # # return self.res

        # # bfs
        # q=Queue()
        # q.put(root)
        # res=0
        # while not q.empty():
        #     curr=q.get()
        #     if(curr.val>=low and curr.val<=high):
        #         res+=curr.val
        #     if(curr.val>low and curr.left is not None):
        #         q.put(curr.left)
        #     if(curr.val< high and curr.right is not None):
        #         q.put(curr.right)
        # return res

        # # bfs 
        st=[]
        res=0
        st.append(root)
        while(st):
            curr=st.pop()
            if(curr.val >=low and curr.val <= high):
                res+=curr.val
            if(curr.val > low and curr.left is not None):
                st.append(curr.left)
            if(curr.val < high and curr.right is not None):
                st.append(curr.right)
        return res


        