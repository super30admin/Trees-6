def verticalOrder(self, root):
    cols = collections.defaultdict(list)
    queue = [(root, 0)]
    i = 0
    while i < len(queue):
        node, x = queue[i]
        i += 1
        if node:
            cols[x].append(node.val)
            queue += (node.left, x - 1), (node.right, x + 1)
    return [cols[x] for x in sorted(cols)]
