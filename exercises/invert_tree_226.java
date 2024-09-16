// import javax.swing.tree.TreeNode;

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

class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        var tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invert(root.left);
        invert(root.right);
    }
}

    // public TreeNode invertTree(TreeNode root) {
    //     return invert(root, root);
    // }
    // public TreeNode invert(TreeNode node, TreeNode root) {
    //     if (node == null) {
    //         return null;
    //     }
    //     var tempNode = node.left;
    //     node.left = node.right;
    //     node.right = tempNode;
    //     invert(node.left, root);
    //     invert(node.right, root);
    //     return root;
    // }
