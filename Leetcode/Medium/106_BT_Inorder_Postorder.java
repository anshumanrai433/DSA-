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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int mid = left;
        while (inorder[mid] != root.val) mid++;
        root.right = build(inorder, postorder, mid + 1, right);
        root.left = build(inorder, postorder, left, mid - 1);
        return root;
    }
}
