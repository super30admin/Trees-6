# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    '''
    Accepted on leetcode(297)
    time - O(N)
    space - O(N)
    '''

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        retStr = ""

        # edge case
        if root == None:
            return retStr

        queue = []
        queue.append(root)

        # BFS
        while queue:
            front = queue.pop(0)

            if front == None:
                retStr += "NULL,"
            else:
                retStr += str(front.val) + ","
                queue.append(front.left)
                queue.append(front.right)

        # removing the nulls added at end of string to optimize the deserialize method.
        while not retStr[len(retStr) - 1].isnumeric():
            retStr = retStr[0:len(retStr) - 1]

        return retStr

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        # edge case
        if data == "":
            return None

        # split data in a string into a list for further deserializing process.
        processed = data.split(',')
        index = 0  # maintain an index variable to check for out of bound condition.

        # create a root node , increment index and add the root to the queue for BFS.
        root = TreeNode(int(processed[index]))
        index += 1

        queue = []
        queue.append(root)

        # BFS for deserializing the string to Tree.
        while queue and index < len(processed):
            front = queue.pop(0)

            # if data is null at current position do not add that to tree and also check for if the index has not reached out of bounds. Repeat this for both left and right branches and increment index each time to access next value in processed list.
            if index < len(processed) and processed[index] != "NULL":
                front.left = TreeNode(int(processed[index]))
                queue.append(front.left)
            index += 1

            if index < len(processed) and processed[index] != "NULL":
                front.right = TreeNode(int(processed[index]))
                queue.append(front.right)
            index += 1

        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))