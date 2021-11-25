# // Time Complexity :O(n)-going through all nodes
# // Space Complexity :O(n) - queue
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def verticalOrder(self, root):
        #Your code here
        q=[]
        ind=[]
        q.append(root)
        ind.append(0)
        result=[]
        hmap={}
        minn=math.inf
        maxx=-9999999999
        while q:
            curr=q.pop(0)
            temp=ind.pop(0)
            if temp not in hmap.keys():
                hmap[temp]=[]
            hmap[temp].append(curr.data)
            minn=min(minn,temp)
            maxx=max(maxx,temp)
            if curr.left:
                q.append(curr.left)
                ind.append(temp-1)
            if curr.right:
                q.append(curr.right)
                ind.append(temp+1)
        for i in range(minn,maxx+1):
            if i in hmap.keys():
                li=hmap[i]
                for j in li:
                    result.append(j)
        return result
