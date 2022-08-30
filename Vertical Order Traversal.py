""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

def verticalOrder(self, root):
    q = []
    idx = []
    q.append(root)
    idx.append(0)
    result = []
    h = {}
    minn = float('inf')
    maxx = float('-inf')
    while q:
        curr = q.pop(0)
        temp = idx.pop(0)
        if temp not in h.keys():
            h[temp] = []
        h[temp].append(curr.data)
        minn = min(minn, temp)
        maxx = max(maxx, temp)
        if curr.left:
            q.append(curr.left)
            idx.append(temp - 1)
        if curr.right:
            q.append(curr.right)
            idx.append(temp + 1)
    for i in range(minn, maxx + 1):
        if i in h.keys():
            li = h[i]
            for j in li:
                result.append(j)
    return result