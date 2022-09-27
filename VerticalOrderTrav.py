# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q=deque()
        res=[]
        mini,maxi=0,0
        dict1={}
        if not root:
            return []
        q.append((root,0))
        while q:
            curr,level=q.popleft()
            if level not in dict1:
                mini=min(mini,level)
                maxi=max(maxi,level)
                dict1[level]=[]
            dict1[level].append(curr.val)
            if curr.left:
                q.append((curr.left,level-1))
            if curr.right:
                q.append((curr.right,level+1))
        for i in range(mini,maxi+1):
            res.append(dict1[i])
        return res
        