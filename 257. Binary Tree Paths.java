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
    List<String> pathList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) 
            binaryTreePathsHelper(root, "");
        return pathList;
    }
    
    public void binaryTreePathsHelper(TreeNode node, String path) {
        path += Integer.toString(node.val);
        if (node.left == null && node.right == null)
            pathList.add(path);
        path += "->";
        if (node.left != null)
            binaryTreePathsHelper(node.left, path);
        if (node.right != null)
            binaryTreePathsHelper(node.right, path);
    }
}

