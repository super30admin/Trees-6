# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS level order traversal. Here BFS is the optimal approach as it naturally sorts the tree from top to bottom and left to right level by level.
# For DFS we need to sort the list
# For root we consider vertical level to be 0. So the left child of the root will be level-1 and right child will be level+1
# We maintain a hashmap for each vertical level and list of nodes values in that level
# Instead of sorting the hashmap which will take nlogn we will maintain minval and maxval when we append the node to the queue as the levels are contiguous.
# So the minval will be the lowest level value and maxvalue will be the highest level value.
# Then we iterate from minval to maxval+1 and append the node values to res

from collections import deque
from collections import defaultdict


def verticalOrder(self, root: TreeNode) -> List[List[int]]:
    if not root:
        return None
    queue = deque([(root, 0)])
    dict = defaultdict(list)
    minval = 0
    maxval = 0
    res = []
    while queue:
        node, level = queue.pop()
        if node.left:
            queue.append((node.left, level - 1))
            minval = min(minval, level - 1)
        if node.right:
            queue.append((node.right, level + 1))
            maxval = max(maxval, level + 1)
        if level in dict:
            dict[level].append(node.val)
        else:
            dict[level] = [node.val]
    for i in range(minval, maxval + 1):
        res.append(dict[i])
    return res