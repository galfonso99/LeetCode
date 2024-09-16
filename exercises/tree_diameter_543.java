// import com.sun.source.tree.Tree;

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
public class tree_diameter_543 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var tree1 = new TreeNode(1, new TreeNode(2), null);
        // var tree2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        // var res = sol.diameterOfBinaryTree(tree1);
        // System.out.printf("res: %d\n", res);
        //
        // var res = sol.reverseList(list);
        // out.printf("The result is %d %n", res.val);
    }
}
class Solution_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
    int diameter (TreeNode node) {
        if (node == null) {
            return 0;
        }
        var leftHeight = depth(node.left, 0);
        var rightHeight = depth(node.right, 0);

        return Math.max(
            leftHeight + rightHeight,
            Math.max ( diameter(node.left), diameter(node.right))
        ); 
        // return Math.max(diameter, diameter(node.left, diameter + 1) + diameter(node.right, diameter + 1));
    }
    int depth (TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        return Math.max(
            depth(node.left, height + 1),
            depth(node.right, height + 1)
        );
    }
}
