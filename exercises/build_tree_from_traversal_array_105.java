// Optimal Solution and using a stop value
class Solution {
    private int in = 0;
    private int pre = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre]);
        pre += 1;
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;        
    }
}
// Inefficient Solution using array slices (not worth it)
// But easier to remember maybe
//class Solution {
//	int pre = -1;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (inorder.length == 0) return null;
//        this.pre += 1;
//        int ind = indexOf(inorder, preorder[pre]);
//        TreeNode node = new TreeNode(inorder[ind]);
//        node.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, ind));
//        node.right = buildTree(preorder, Arrays.copyOfRange(inorder, ind+1, inorder.length));
//        return node;
//    }
//    int indexOf(int[] array, int number){
//        int index = 0;
//        for(int n: array){
//            if(number == n) return index;
//            else index++;
//        }
//        return -1;
//    }
//}

