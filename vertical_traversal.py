# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    """
    TC:O(n)
    SC:O(n)
    """

    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        mapp = defaultdict(list)
        minn, maxx = 0, 0
        q = deque()
        q.append((root, 0, 0))
        while q:
            curr, r, c = q.pop()
            if curr:
                mapp[c].append([r, curr.val])
                if(curr.left != None):
                    q.append((curr.left, r+1, c - 1))
                    minn = min(minn, c-1)
                if(curr.right != None):
                    q.append((curr.right, r+1, c + 1))
                    maxx = max(maxx, c+1)
        print(minn, maxx)
        res = []
        for col in range(minn, maxx+1):
            res.append([val for r, val in sorted(mapp[col])])

        return res
