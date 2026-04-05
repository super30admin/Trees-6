
/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 Intuition:
 1) Using dfs inorder traversal to solve this problem.
 2) Optimized the traversal by only traversing the nodes if the node values is in the given range of values
 3) Result is added with the node values that are in range and return the result;
 T.C: O(n), S.C: O(n)
 */
var rangeSumBST = function(root, low, high) {
    const helper = (root) => {
        if(!root) return 0;

        let result = 0;

        // left subtree
        if(root.val > low)
        result += helper(root.left);

        // curr node processing
        if(root.val >= low && root.val <= high) result += root.val;
        
        // right subtree
        if(root.val < high)
        result += helper(root.right);

        return result;
    }

    return helper(root);
    
};