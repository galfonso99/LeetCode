import java.lang.Math;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class balanced_tree_110 {
    public static void main(String[] args) {
        var sol = new Solution();
        // var tree1 = new TreeNode(1, new TreeNode(2), null);
        // var tree2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        // var res = sol.diameterOfBinaryTree(tree1);
        // System.out.printf("res: %d\n", res);
    }
}
// Optimal solution
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)  return true;
        boolean heightIsBalanced = Height(root) != -1;
		return heightIsBalanced;
	}

	public int Height(TreeNode root) {
		if (root == null)  return 0;
		int leftHeight = Height(root.left);
		int rightHight = Height(root.right);
		if (leftHeight == -1 || rightHight == -1)  return -1;
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
		return Math.max(leftHeight, rightHight) + 1;
    }
}

// My original solution
// class Solution {
//     boolean balanced = true;
//     public boolean isBalanced(TreeNode root) {
//         if (root == null) return true;
//         depth(root);
//         return this.balanced;
//     }
//     int depth (TreeNode node) {
//         if (node == null) {
//             return 0;
//         }
//
//         var left = depth(node.left);
//         var right = depth(node.right);
//
//         if (Math.abs(left - right) > 1) {
//             this.balanced = false;
//         }
//         return Math.max(left, right) + 1;
//     }
//
// }


