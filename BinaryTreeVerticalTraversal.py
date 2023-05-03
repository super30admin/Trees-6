#All TC passed on leetcode


import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    #Here we traverse the tree using BFS. We keep track of col number and cur nodes using 2 separate queues for both.
    #We store the nodes accrding to their col number in a map. After tree traversal, we iterate through the map from min col to max col number
    #and append their corresponding lists to result
    #time complexity - O(n)
    #space commplexity - O(n) - for queue and map size
    def BTVerticalOrder(self, root):
        q = collections.deque()
        cols = collections.deque()
        map = {}
        minR = 0
        maxR = 0
        res = []
        
        q.append(root)
        cols.append(0)
        
        while q:
            cur = q.popleft()
            col = cols.popleft()
            if col not in map:
                map[col] = []
            map[col].append(cur.val)
            
            if cur.left:
                q.append(cur.left)
                cols.append(col-1)
            
            if cur.right:
                q.append(cur.right)
                cols.append(col+1)
                
            minR = min(minR, col)
            maxR = max(maxR, col)
            
        for i in range(minR, maxR+1):
            vals = map[i]
            res.append(vals)
        
        return res
 
t = TreeNode(3)
t.left = TreeNode(9)
t.right = TreeNode(8)
t.left.left = TreeNode(4)
t.left.right = TreeNode(0)
t.left.right.left = TreeNode(5)
t.right.left = TreeNode(1)
t.right.left.right = TreeNode(2)
t.right.right = TreeNode(7)

s = Solution()
res = s.BTVerticalOrder(t)
print(res)
            
        
        