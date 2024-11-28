// Original Solution
class Solution {
    public boolean isValidBST(TreeNode root) {
		return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	boolean solve(TreeNode node, long min, long max) {
		if (node == null) return true;
		if (node.val <= min || node.val >= max) return false;
		return solve(node.left, min, node.val) && solve(node.right, node.val, max);
	}
}

