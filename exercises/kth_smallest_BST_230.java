// Recursive Sol
class Solution {
    int count = 0;
    int value = -1;
    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return this.value;
    }
    void solve(TreeNode node, int k) {
        if (node == null) return;
        kthSmallest(node.left, k);
        if (this.value >= 0) return;
        this.count +=1;
        if (this.count == k) this.value = node.val;
        kthSmallest(node.right, k);
    }
}

// Iterative Sol
//class Solution {
//	public int kthSmallest(TreeNode root, int k) {
//		Stack<TreeNode> st = new Stack<>();
//
//		while (root != null) {
//			st.push(root);
//			root = root.left;
//		}
//
//		while (k != 0) {
//			TreeNode n = st.pop();
//			k--;
//			if (k == 0) return n.val;
//			TreeNode right = n.right;
//			while (right != null) {
//				st.push(right);
//				right = right.left;
//			}
//		}
//
//		return -1; // never hit if k is valid
//	}
//}
