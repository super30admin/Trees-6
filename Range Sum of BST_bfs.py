#time: O(n)
#space: O(m) where m is the no.of leaf nodes

#bfs


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        q=deque()
        sum1=0
        q.append(root)
        while(q!=deque()):
            size=len(q)
            for i in range(size):
                r=q.popleft()
                if(low<=r.val<=high):
                    sum1+=r.val
                if(r.left!=None):
                    q.append(r.left)
                if(r.right!=None):
                    q.append(r.right)
        return sum1
            
            