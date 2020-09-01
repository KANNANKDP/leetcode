/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }
    
    public int dfs(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }
        int leftSum = L < node.val ? dfs(node.left, L, R) : 0;
        int rightSum = node.val < R ? dfs(node.right, L, R) : 0;
        if (L <= node.val && node.val <= R) {
            return node.val + leftSum + rightSum;
        }
        return leftSum + rightSum;
    }
}

