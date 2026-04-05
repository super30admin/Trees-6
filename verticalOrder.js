/**
 * @param {TreeNode} root
 * @return {number[][]}
 Intuition:
 Use **BFS with a column index** (left = -1, right = +1) to group nodes by vertical columns.
 BFS guarantees **top-to-bottom and left-to-right order** within each column.
 Track **min/max column** and build the result from leftmost to rightmost.
 T.C: O(n), S.C: O(n)
 */
var verticalOrder = function (root) {
    if (!root) return [];
    // bfs
    let map = new Map();
    let result = [];
    let queue = [[root, 0]];
    let min = 0, max = 0;
    let j = 0;
    while (j < queue.length) {
        let [curr, level] = queue[j++];
        min = Math.min(level, min);
        max = Math.max(level, max);
        // process the node
        if (!map.has(level)) map.set(level, []);
        map.get(level).push(curr.val);

        // left sub tree
        if (curr.left) {
            queue.push([curr.left, level - 1]);
        }

        // right sub tree
        if (curr.right) {
            queue.push([curr.right, level + 1]);
        }

    }

    // iterate over the map and create the result
    for (let i = min; i <= max; i++) {
        result.push(map.get(i));
    }

    return result;
};