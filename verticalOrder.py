# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        nodes = []
        queue = collections.deque()

        def bfs(root):
            queue.append((0,root))
            while queue:
                col,node = queue.popleft()
                if node:
                    nodes.append((col,node.val))
                    queue.append((col-1,node.left))
                    queue.append((col+1,node.right))
                    
        bfs(root)
        
        nodes = sorted(nodes, key=lambda node: node[0])
        
        dic = OrderedDict()
        
        for col,val in nodes:
            if col in dic:
                dic[col].append(val)
            else:
                dic[col]=[val]
                
        return dic.values()
        
        
        
        #tc is o(nlogn)
        #sc is o(n)
