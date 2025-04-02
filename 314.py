# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        result = []
        map1 = {}
        que1 = deque()
        que2 = deque()
        que1.append(root)
        que2.append(0)
        min1 = float('inf')
        max1 = -float('inf')
        while que1:
            curr = que1.popleft()
            dist =que2.popleft()
            min1 = min(min1, dist)
            max1 = max(max1, dist)

            if dist not in map1:
                map1[dist] = []
            map1[dist].append(curr.val)
            if curr.left:
                que1.append(curr.left)
                que2.append(dist -1)
            if curr.right:
                que1.append(curr.right)
                que2.append(dist+1)
        for i in range(min1, max1+ 1):
            result.append(map1[i])
        return result

        #TC : O(n)
       # SC : O(n)