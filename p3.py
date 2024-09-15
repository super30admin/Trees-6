class Solution:
   def verticalOrder(TreeNode root):
        result = []
        if(root == None): return result
        hashmap = {}
        q = collections.deque()
        cols = collections.deque()
        q.append(root)
        cols.append(0)
        minn = 0;  maxx = 0
        
        while(q):
            curr = q.popleft()
            col = cols.popleft()
            if(!hashmap[col]):
                hashmap[col]= []
            
            hashmap[col].append(curr.val)
            if(curr.left != None):
                q.append(curr.left)
                cols.append(col - 1)
                minn = min(minn, col - 1)
            
            if(curr.right != None):
                q.append(curr.right)
                cols.append(col + 1)
                maxx = max(maxx, col + 1)
            
        
        for i in range(min,max):
            result.append(hashmap[i])
        
        return result
   
