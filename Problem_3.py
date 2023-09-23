# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
  def verticalOrder(self, root):
    if not root:
      return []
    range_ = ([0] * 2)

    def getRange(root, x):
      if not root:
        return
      range_[0] = min(range_[0], x)
      range_[1] = max(range_[1], x)
      getRange(root.left, x - 1)
      getRange(root.right, x + 1)
    getRange(root, 0)
    ans = [[] for _ in range(range_[1] - range_[0] + 1)]
    q = collections.deque([(root, -range_[0])])
    while q:
      node, x = q.popleft()
      ans[x].append(node.val)
      if node.left:
        q.append((node.left, x - 1))
      if node.right:
        q.append((node.right, x + 1))
    return ans