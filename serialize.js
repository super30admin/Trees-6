// Time, Space - O(N), O(Width) for both
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
var serialize = function(root) {
    if(root === null) {
        return root;
    }
    
    let q = [root];
    let result = ``;
    
    while(q.length !== 0) {
        let cur = q.shift();
        if(cur !== null) {
            result += `${cur.val},`;            
            q.push(cur.left);
            q.push(cur.right);
        }
        else {
            result += 'null,'
        }   
    }
    return result;
    
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    if(data === null || data.length === 0) {
        return null;
    }
    let nodes = data.split(',');
    
    let root = new TreeNode(parseInt(nodes[0]));
    let q = [root];
    let i = 1;
    
    while(q.length !== 0 && i < nodes.length) {
        let node = q.shift();
        
        if(nodes[i] !== 'null') {
           node.left = new TreeNode(parseInt(nodes[i]));
            q.push(node.left);
        }
        i++;
        if(nodes[i] !== 'null') {
            node.right = new TreeNode(parseInt(nodes[i]));  
            q.push(node.right);
        }
        i++;
    }
    
    return root;
    
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
