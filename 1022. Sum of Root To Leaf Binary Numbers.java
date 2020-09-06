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
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafHelper(root, 0);
        return res;
    }
    
    private void sumRootToLeafHelper(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num << 1 | root.val;
        if (root.left == null && root.right == null) {
            res += (int) num;
            return;
        }
        sumRootToLeafHelper(root.left, num);
        sumRootToLeafHelper(root.right, num);
    }
}

