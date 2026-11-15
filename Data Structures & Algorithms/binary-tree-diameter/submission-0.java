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
    private int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDia;
    }

    private int height(TreeNode root){
        if( root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        int diameter = left + right;
        maxDia = Math.max(maxDia , diameter);
        return 1 + Math.max(left , right);
    }
}
