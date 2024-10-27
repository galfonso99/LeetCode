// Original solution with some tuning (Original soluion means first solution that
// was mine that passed all tests)
class Solution {
	int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0; 
        solve(root, root.val);
        return this.count;
    }
	void solve(TreeNode node, int max) {
		if (node.val >= max) {this.count += 1; max = node.val;}
		if (node.left != null) solve(node.left, max);
		if (node.right != null) solve(node.right, max);
	}
}
// Keep a class attr for count of good nodes
// Recursively visit the tree and maintain the max value found the far
// if curr node is not lesser than max then you can mark that node as good
