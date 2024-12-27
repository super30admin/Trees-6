#Time Complexity: O(N), where N is the number of nodes in the tree. Each node is visited once, and the horizontal distance updates are O(1).
#Space Complexity: O(N), for the queue and the hashmap storing the node values.
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if(root==None):
            return []
        result = list()
        hashmap = defaultdict()
        nodesq = deque()
        widthq = deque()
        nodesq.append(root)
        widthq.append(0)
        minimum = 0
        maximum = 0
        while(len(nodesq)>0):
            node = nodesq.popleft()
            currwidth = widthq.popleft()
            if(currwidth not in hashmap):
                hashmap[currwidth] = [node.val]
            else:
                hashmap[currwidth].append(node.val)
            if(node.left!=None):
                nodesq.append(node.left)
                widthq.append(currwidth-1)
                minimum = min(minimum,currwidth-1)
            if(node.right!=None):
                nodesq.append(node.right)
                widthq.append(currwidth+1)
                maximum = max(maximum,currwidth+1)
        for i in range(minimum,maximum+1):
            result.append(hashmap[i])
        return result