// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
public class same_tree_100 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        // var tree2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        // var res = sol.isSameTree(tree1, tree2);
        // System.out.printf("res: %b\n", res);
    }
}
class Solution_100 {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.val == b.val) && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
	}
}

/*
 * Two trees are the same if they are structually equivalent and the values of the nodes are 
 * equal in their corresponding positions
 *
 * You probably need to recursively call the function such that the node is equal and
 * the left side is equal and the right side is equal
 */
