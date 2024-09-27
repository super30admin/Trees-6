# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:return []
        
        vertical_order = defaultdict(list)
        min_col, max_col = 0, 0
        
        q = deque([(root, 0)])
        
        while q:
            node, col = q.popleft()
            vertical_order[col].append(node.val)
            
            if node.left:
                q.append((node.left, col-1))
                min_col = min(min_col, col-1)
                
            if node.right:
                q.append((node.right, col+1))
                max_col = max(max_col, col+1)
        
        
        res = []
        for i in range(min_col, max_col+1):
            res.append(vertical_order[i])
            
        return res
