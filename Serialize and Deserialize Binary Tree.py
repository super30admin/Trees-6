# Time complexity: O(n)
# space complexity: O(n)
# Approach: convert the tree into string with level order travseral including NOne values for serialize function
# To deserialize,
#convert the string to list by splitting at ','
# insert the element into queue one by one by popping out
# point a cursor to point at next element in list
# if the value at cursor is not None, assign it to left first and then to right by moving the cursor, insert the non None elements into queue.


from collections import deque
class Codec:

    def serialize(self, root):
        res=""
        q=deque()
        q.append(root)

        while q:
            cur=q.popleft()

            if cur is None:
                res+=str(None)
            else:
                res+=str(cur.val)

            res+=","

            if cur:
                q.append(cur.left)
                q.append(cur.right)
        return res

        

    def deserialize(self, data):
        if data is None:
            return None
        q=deque()
        s=data.split(",")
        if s[0] == "None":
            return None
        root = TreeNode(int(s[0]))
        q.append(root)
        i=1
        while q:
            cur = q.popleft()

            if cur:
                if s[i]!="None":
                    cur.left = TreeNode(int(s[i]))
                q.append(cur.left)
                i+=1
                if s[i]!="None":
                    cur.right = TreeNode(int(s[i]))
                q.append(cur.right)
                i+=1

        return root