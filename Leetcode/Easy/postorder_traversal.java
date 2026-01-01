class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();

            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) stack.push(curr.left);
                else if (curr.right != null) stack.push(curr.right);
            } else if (curr.left == prev) {
                if (curr.right != null) stack.push(curr.right);
            } else {
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
}
