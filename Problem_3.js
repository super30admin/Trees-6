// ## Problem3: Vertical order tree traversal https://leetcode.com/problems/binary-tree-vertical-order-traversal/

// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var verticalOrder = function (root) {
    if (root === null)
        return [];

    let queue = [];
    queue.push([root, 0])
    let map = new Map();
    let min = 0;
    let max = 0;
    // BFS
    // Maintain the vertical position number as well
    while (queue.length > 0) {
        let curr = queue.shift();
        let node = curr[0];
        let height = curr[1];
        min = Math.min(min, height);
        max = Math.max(max, height);
        if (!map.has(height)) {
            map.set(height, []);
        }
        map.set(height, [...map.get(height), node.val]);
        // The vertical position will be height-1 for left child
        if (node.left !== null) {
            queue.push([node.left, height - 1]);
        }
        // The vertical position will be height+1 for right child
        if (node.right !== null) {
            queue.push([node.right, height + 1]);
        }
    }

    let result = [];
    for (let i = min; i <= max; i++) {
        result.push(map.get(i));
    }

    return result;
};
