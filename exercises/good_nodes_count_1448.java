// Better solution without the need for a class variable
class Solution {
    public int goodNodes(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        return solve(root, prev);
    }

    public static int solve(TreeNode root, int prev) {
        if(root == null) { return 0; }
        if(root.val < prev) {
            return solve(root.left, prev) + solve(root.right, prev);
        }
        return 1 + solve(root.left, root.val) + solve(root.right, root.val);
    }
}

// Original solution with some tuning (Original solution means first solution that
// was mine that passed all tests)
//class Solution {
//	int count = 0;
//    public int goodNodes(TreeNode root) {
//        if(root == null) return 0; 
//        solve(root, root.val);
//        return this.count;
//    }
//	void solve(TreeNode node, int max) {
//		if (node.val >= max) {this.count += 1; max = node.val;}
//		if (node.left != null) solve(node.left, max);
//		if (node.right != null) solve(node.right, max);
//	}
//}

