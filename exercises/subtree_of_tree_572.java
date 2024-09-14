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
public class subtree_of_tree_572 {
    public static void main(String[] args) {
        var sol = new Solution_56();
        var tree1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        var tree2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        var res = sol.isSubtree(tree1, tree2);
        System.out.printf("res: %b\n", res);
    }
}
class Solution_56 {
    public boolean isSubtree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val == b.val) {
            return isSubtree(a.left, b.left) && isSubtree(a.right, b.right);
        }
        return isSubtree(a.left, b) || isSubtree(a.right, b);
    }
}

/*
 * Given an original tree and a possible subtree figure out if the second tree is a 
 * proper subtree of the original tree
 * For the second tree to be a subtree of the original tree there must be a node in 
 * the original tree which if taken as the root would be equivalent to the second tree
 */
