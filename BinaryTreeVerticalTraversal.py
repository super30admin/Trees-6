#Time Complexity: O(n)
#Space Complexity: O(n)
#Successfully ran on leetcode
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        res = []
        queue = [[root,0]]
        d = {}
        minimum,maximum = float('inf'),float('-inf')
        while queue:
            root,lvl = queue.pop(0)
            if lvl not in d:
                d[lvl]=[root.val]
            else:
                d[lvl].append(root.val)
            if root.left:
                queue.append([root.left,lvl-1])
            if root.right:
                queue.append([root.right,lvl+1])
            maximum = max(maximum,lvl)
            minimum = min(minimum,lvl)
        for i in range(minimum,maximum+1):
            res.append(d[i])
        return res
