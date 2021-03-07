// Time, Space -  O(N), O(N)
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
    if (!root) {
        return 0
    }
    
    const { val, left, right } = root
    return (val >= L && val <= R ? val : 0) + rangeSumBST(left, L, R) + rangeSumBST(right, L, R)  
};
