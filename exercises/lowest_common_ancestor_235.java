class lowestCommonAncestor235 {
	public static void main(String[] args) {
		// A bunch of tests to test my solution
		// As simple as possible cuz I dont wanna setup unit test in Java, God help me
		var sol = new Solution();
		var tn = new TreeNode(3, new TreeNode(8, new TreeNode(0), new TreeNode(2, new TreeNode(2), 
			new TreeNode(7))), new TreeNode(5, new TreeNode(6), new TreeNode(11)));
		var copy1 = tn;
		var p1 = copy1.left;
		var q1 = copy1.right;
		var sol1 = sol.lowestCommonAncestor(copy1, p1, q1);
		System.out.printf("For sol1 I expected node %d, and got node %d, and the test passed? %b\n", System.identityHashCode(copy1), System.identityHashCode(sol1), copy1 == sol1);
		var copy2 = tn;
		var p2 = copy2.left.right.left;
		var q2 = copy2.left.right.right;
		var sol2 = sol.lowestCommonAncestor(copy2, p2, q2);
		System.out.printf("For sol2 I expected node %d, and got node %d, and the test passed? %b\n", System.identityHashCode(copy2.left.right), System.identityHashCode(sol2), copy2.left.right == sol2);
		var copy3 = tn;
		var p3 = copy3.left.right.left;
		var q3 = copy3.right.right;
		var sol3 = sol.lowestCommonAncestor(copy3, p3, q3);
		var expected3 = copy3;
		System.out.printf("For sol3 I expected node %d, and got node %d, and the test passed? %b\n", System.identityHashCode(expected3), System.identityHashCode(sol3), expected3 == sol3);
		var copy4 = tn;
		var p4 = copy4.left.right;
		var q4 = copy4.left.right.right;
		var sol4 = sol.lowestCommonAncestor(copy4, p4, q4);
		var expected4 = p4;
		System.out.printf("For sol4 I expected node %d, and got node %d, and the test passed? %b\n", System.identityHashCode(expected4), System.identityHashCode(sol4), expected4 == sol4);
	}
}
// Optimal solition using the fact that it's a BST and each value is unique
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p.val > q.val) {
//            TreeNode temp = p;
//            p = q;
//            q = temp;
//        }
//        TreeNode node = root;
//        while (node != null) {
//            if (node.val >= p.val && node.val <= q.val)
//                return node;
//
//            node = node.val > q.val ? node.left : node.right;
//        }
//
//        return null;
//    }
//}
//Solution I came up with when I didn't notice the tree was a BST and it should work
// for any tree and even if the values are duplicate
class Solution {
	TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.rec(root, p, q);
		return this.ancestor;
    }
	boolean rec(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		boolean leftTrue = rec(root.left, p, q);
		boolean rightTrue = rec(root.right, p, q);
		if (leftTrue && rightTrue || ((root == p || root == q) && (leftTrue || rightTrue))) {
			this.ancestor = root;
			return false;
		}
		return root == p || root == q || leftTrue || rightTrue;
	}
}
