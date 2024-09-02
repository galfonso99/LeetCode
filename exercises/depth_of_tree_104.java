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

class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
    int depth (TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        return Math.max(depth(node.left, height+1), depth(node.right, height+1));
    }
}
