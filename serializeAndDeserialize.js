/**
Intuition:
1. Serialize: Traverse the tree level by level (BFS), recording node values and `#` for nulls to preserve structure.
2. Deserialize: Rebuild the tree using a queue, assigning left and right children in order from the serialized list.
3. Maintain root reference:** Always return the original root so the reconstructed tree is complete.
T.C: O(n)
S.C: O(n)
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
    // base case
    if (!root) return '';
    let queue = [root];
    let i = 0;
    let result = [];
    while (i < queue.length) {
        const curr = queue[i++];
        if (!curr) {
            result.push('#');
        } else {
            result.push(curr.val);
            queue.push(curr.left);
            queue.push(curr.right);
        }
    }
    return result.join(',');
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
    // base case
    if (!data) return null;
    const deserializedArr = data.split(',');
    let idx = 0;
    let root = new TreeNode(Number(deserializedArr[idx]));
    idx++;
    let queue = [root];

    while (queue.length) {
        let curr = queue.shift();
        // left child
        if (idx < deserializedArr.length && deserializedArr[idx] !== '#') {
            curr.left = new TreeNode(Number(deserializedArr[idx]));
            queue.push(curr.left);
        }
        idx++;
        // right child
        if (idx < deserializedArr.length && deserializedArr[idx] !== '#') {
            curr.right = new TreeNode(Number(deserializedArr[idx]));
            queue.push(curr.right);
        }
        idx++;
    }
    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */