# Time Complexity: O(n)
# Space Complexity: O(n)
class Codec:
    
    def serialize(self, root):
        result = ''
        if root == None:
            return result
        q = deque()
        q.append(root)
        while q:
            curr = q.popleft()
            if curr == None:
                result += 'NULL,'
            else:
                result += str(curr.val) + ','
                q.append(curr.left)
                q.append(curr.right)
                
        # while not result[len(result) - 1].isnumeric():
        #     result = result[0:len(result) - 1]
        return result
        

    def deserialize(self, data):
        if data == '':
            return None
        processed = data.split(',')
        i = 0
        root = TreeNode(int(processed[i]))
        i += 1
        q = deque()
        q.append(root)
        while q and i < len(processed):
            curr = q.popleft()
            if i < len(processed) and processed[i] != 'NULL':
                curr.left = TreeNode(int(processed[i]))
                q.append(curr.left)
            i += 1
            if i < len(processed) and processed[i] != 'NULL':
                curr.right = TreeNode(int(processed[i]))
                q.append(curr.right)
            i += 1
        return root
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))