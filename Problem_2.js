// ## Problem2: Serialize and Deserialize Binary Tree (https://leetcode.com/problems/serialize-and-deserialize-binary-tree)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
    if (root === null)
        return "";
    let str = "";
    let queue = [];
    queue.push(root);
    // BFS
    while (queue.length > 0) {
        let curr = queue.shift();

        if (curr !== null) {
            queue.push(curr.left);
            queue.push(curr.right);
            str += `${curr.val},`;
        } else {
            str += 'null,';
        }
    }
    return str;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
    if (data.length === 0)
        return null;

    let nodes = data.split(',');
    console.log(nodes)
    let queue = [];
    let root = new TreeNode(parseInt(nodes[0]));
    queue.push(root);
    let i = 1;
    while (queue.length > 0) {
        let curr = queue.shift();
        if (nodes[i] !== "null") {
            curr.left = new TreeNode(parseInt(nodes[i]));
            queue.push(curr.left)
        }
        i++;
        if (nodes[i] !== "null") {
            curr.right = new TreeNode(parseInt(nodes[i]));
            queue.push(curr.right)
        }
        i++;
    }
    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */