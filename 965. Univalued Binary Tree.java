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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root.val);
    }
    
    private boolean isUnivalTreeHelper(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        return isUnivalTreeHelper(node.left, val) && 
            isUnivalTreeHelper(node.right, val);
    }
}

class Solution2 {
    public boolean isUnivalTree(TreeNode root) {
        boolean leftCorrect = (root.left == null ||
                               (root.val == root.left.val && isUnivalTree(root.left)));
        boolean rightCorrect = (root.right == null ||
                               (root.val == root.right.val && isUnivalTree(root.right)));
        return leftCorrect && rightCorrect;
        
    }
}

