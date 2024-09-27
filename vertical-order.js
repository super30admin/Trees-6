// Time, Space - O(N), O(N)

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
var verticalOrder = function(root) {
     
    if(root === null) {
        return [];
    }
    
    let result = [];
    
    let map = {};
    
    let q = [];
    let cols = [];
    let min = 0;
    let max = 0;
    
    q.push(root);
    cols.push(0);
    
    while(q.length !== 0) {
        let cur = q.shift();
        let col = cols.shift();
        
        if(!map[col]){
            map[col] = [];
        }
        map[col].push(cur.val);
        if(cur.left !== null) {
            q.push(cur.left);
            cols.push(col - 1);
            min = Math.min(col-1,min);
        }
        if(cur.right !== null) {
            q.push(cur.right);
            cols.push(col + 1);
            max = Math.max(max, col + 1);
        }        
    }
    for(let i = min; i<=max;i++) {
        result.push(map[i]);
    }
    return result;
};
