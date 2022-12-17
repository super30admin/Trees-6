// ## Problem1: Sum between two ranges of BST(https://leetcode.com/problems/range-sum-of-bst)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let sum;
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

var dfs = (root, low, high) => {
    if (root === null)
        return;
    dfs(root.left, low, high);
    if (low <= root.val && root.val <= high)
        sum += root.val;
    dfs(root.right, low, high);
}
/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function (root, low, high) {
    if (root === null)
        return 0;
    sum = 0;
    dfs(root, low, high);
    return sum;
};