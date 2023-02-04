#Time Complexity: O(n)
#Space : O(n)
#Successfully ran on leetcode
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return ""
        queue = [root]
        s=""
        while queue:
            root = queue.pop(0)
            if root is None:
                s+="null"
                s+=','
                continue
            s+=str(root.val)
            s+=","
            queue.append(root.left)
            queue.append(root.right)
        return s


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data=="":
            return None
        data = data.split(",")
        data = data[:-1]
        root = TreeNode(int(data[0]))
        queue = [root]
        i=1
        while queue:
            node = queue.pop(0)
            if data[i]!='null':
                node.left = TreeNode(int(data[i]))
                queue.append(node.left)
            i+=1
            if data[i]!='null':
                node.right = TreeNode(int(data[i]))
                queue.append(node.right)
            i+=1   
        return root