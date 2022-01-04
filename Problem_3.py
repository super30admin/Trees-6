# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root == None:
            return result
        hashmap = {}
        q, cols = deque(), deque()
        mini, maxi = 0, 0
        q.append(root)
        cols.append(0)
        while q:
            curr = q.popleft()
            col = cols.popleft()
            if col not in hashmap:
                hashmap[col] = list()
            hashmap[col].append(curr.val)
            if curr.left != None:
                q.append(curr.left)
                cols.append(col-1)
                mini = min(mini, col - 1)
            if curr.right != None:
                q.append(curr.right)
                cols.append(col+1)
                maxi = max(maxi, col + 1)
        for i in range(mini, maxi+1):
            result.append(hashmap[i])
        return result
        
        