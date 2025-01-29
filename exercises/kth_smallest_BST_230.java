// Taking into account the Follow-up: If the BST is modified often (i.e., we can do insert and delete operations) 
// and you need to find the kth smallest frequently, how would you optimize?
// Solve it using Morris Traversal
class Solution {
	public int kthSmallest(TreeNode root, int k) {
		TreeNode current = root;
		int count = 0;

		while (current != null) {
			if (current.left == null) {
				// Process the current node
				count++;
				if (count == k) {
					return current.val;
				}
				current = current.right;
			} else {
				// Find the inorder predecessor
				TreeNode predecessor = current.left;
				while (predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}

				if (predecessor.right == null) {
					// Create a threaded link to the current node
					predecessor.right = current;
					current = current.left;
				} else {
					// Remove the threaded link and process the current node
					predecessor.right = null;
					count++;
					if (count == k) {
						return current.val;
					}
					current = current.right;
				}
			}
		}

		return -1; // k is out of range
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

// Recursive Sol
//class Solution {
//    int count = 0;
//    int value = -1;
//    public int kthSmallest(TreeNode root, int k) {
//        solve(root, k);
//        return this.value;
//    }
//    void solve(TreeNode node, int k) {
//        if (node == null) return;
//        kthSmallest(node.left, k);
//        if (this.value >= 0) return;
//        this.count +=1;
//        if (this.count == k) this.value = node.val;
//        kthSmallest(node.right, k);
//    }
//}

