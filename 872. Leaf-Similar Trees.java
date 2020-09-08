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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();
        leafSimilarHelper(root1, leafNodes1);
        leafSimilarHelper(root2, leafNodes2);
        return leafNodes1.equals(leafNodes2);
    }
    
    private void leafSimilarHelper(TreeNode node, List<Integer> leafNodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafNodes.add(node.val);
        }
        leafSimilarHelper(node.left, leafNodes);
        leafSimilarHelper(node.right, leafNodes);
    }
}

