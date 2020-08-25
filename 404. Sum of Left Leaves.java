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
class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }
    
    private int sumOfLeftLeavesHelper(TreeNode node, boolean leftNode) {
        if (node == null) {
            return 0;
        }
        if (leftNode && node.left == null && node.right == null) {
            return node.val;
        }
        int leftSubTreeSum = node.left != null ? sumOfLeftLeavesHelper(node.left, true) : 0;
        int rightSubTreeSum = node.right != null ? sumOfLeftLeavesHelper(node.right, false) : 0;
        return leftSubTreeSum + rightSubTreeSum;
    }
}

class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        sumOfLeftLeavesHelper(root, sum, false);
        return sum[0];
    }
    
    private void sumOfLeftLeavesHelper(TreeNode node, int[] sum, boolean leftNode) {
        if (node == null) {
            return;
        } else if (leftNode && node.left == null && node.right == null) {
            sum[0] += node.val;
        } else {
            sumOfLeftLeavesHelper(node.left, sum, true);
            sumOfLeftLeavesHelper(node.right, sum, false);
        }
    }
}

