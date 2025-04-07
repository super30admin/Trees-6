from collections import defaultdict, deque
# TC : O(n)
# SC : O(n)
class Node:
    def __init__(self, x):
        self.data = x
        self.left = None
        self.right = None
def verticalOrder(root):
    if root is None:
        return []
    res = []
    q = deque()
    q.append((root,0))
    minv,maxv = float('inf'),float('-inf')
    hmap = {}
    while q:
        curnode,curlevel = q.popleft()
        minv = min(minv,curlevel)
        maxv = max(maxv,curlevel)
        if curlevel not in hmap.keys():
            hmap[curlevel] = [curnode.data]
        else:
            hmap[curlevel].append(curnode.data)
        if curnode.left:
            q.append((curnode.left,curlevel-1))
        if curnode.right:
            q.append((curnode.right,curlevel+1))
    for i in range(minv,maxv+1):
        res.append(list(hmap[i]))
    return res
    
if __name__ == "__main__":

    # Constructing the binary tree:
    #        1
    #       / \
    #      2   3
    #     / \ / \
    #    4  5 6  7
    #          \  \
    #           8  9
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    root.right.left.right = Node(8)
    root.right.right.right = Node(9)

    res = verticalOrder(root)
    
    for temp in res:
        print("[", " ".join(map(str, temp)), "]", end=" ")