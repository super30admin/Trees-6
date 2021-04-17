#Time Complexity:O(n)
#Space Complexity:O(2n)
#Approach:Use the maxdepth recursive call to find the the depth of the function. use a queue to perform level order traversal.
#Assign left node value at vertical order current level-1 and right node value to vertical order current level+1.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        level=self.maxdepth(root)
        level-=1
        result=defaultdict()
        q=deque()
        q.append([root,level])
        maxVertical=level
        while q:
            curr=q.popleft()
            if curr[1] not in result:
                result[curr[1]]=[]
            result[curr[1]].append(curr[0].val)
            if curr[0].left:
                q.append([curr[0].left,curr[1]-1])
            if curr[0].right:
                q.append([curr[0].right,curr[1]+1])
            if curr[1]>maxVertical:
                maxVertical=curr[1]
        answer=[]
        for i in range(maxVertical+1):
            if i in result:
                answer.append(result[i])
        return answer
            
        
    def maxdepth(self,root:TreeNode) ->int:
        if not root:
            return 0
        return max(self.maxdepth(root.left),self.maxdepth(root.right))+1