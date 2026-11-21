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
    private int idx = 0;
    private Map<Integer , Integer > map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        map.clear();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i] , i);
        }
        return Construct(preorder , 0 , inorder.length - 1);
    }
    private TreeNode Construct(int[] preorder , int left , int right){
        if(left > right) return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        int rootIndex = map.get(val);
        root.left = Construct(preorder , left , rootIndex - 1);
        root.right = Construct(preorder , rootIndex + 1 , right );
        return root;
           }
}
