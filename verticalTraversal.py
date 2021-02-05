"""
TC and SC 0(N)

Use BFS and keep doing idx-1 for left subtree and indx+1 for right subtree and put it in hashmap. we store r, so that we can get same order value inside the sub-list


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        map_ = defaultdict(list)
        mini, maxi = 0, 0
        q = []
        q.append((root,0, 0)) #node, row,col
        while q:
            curr,r, c = q.pop()
            if curr:
                map_[c].append([r,curr.val])
                #print(map_)
                if(curr.left!=None):
                    q.append((curr.left,r+1,c - 1))
                    mini = min(mini, c-1)
                if(curr.right!=None):
                    q.append((curr.right,r+1,c + 1))
                    maxi = max(maxi, c+1)
        res = []
        for col in range(mini,maxi+1):
                res.append([val for r, val in sorted(map_[col])])

        return res