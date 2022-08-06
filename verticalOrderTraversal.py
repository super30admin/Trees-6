#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        q = deque()
        q.append((root,0))
        hmap = {}
        minKey = float(inf)
        maxKey = float(-inf)
        res = []
        while q:
            curr,level = q.popleft()
            
            if level not in hmap:
                minKey = min(level,minKey)
                maxKey = max(level,maxKey)
                hmap[level] = []
                
            hmap[level].append(curr.val)
            
            if curr.left:
                q.append((curr.left,level-1))
    
            if curr.right:
                q.append((curr.right,level+1))
                
        for i in range(minKey,maxKey+1):
            res.append(hmap[i])
            
        return res