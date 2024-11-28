function isValidBST(root: TreeNode | null, min: number = -Infinity, max: number = Infinity): boolean {
	if (!root) return true;
 	if (root.val <= min || root.val >= max) return false;
	return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
};

// Alternative without default params
//function isValidBST(root: TreeNode | null): boolean {
//	return solve(root, -2147483649, 2147483649);
//};
//function solve(node: TreeNode | null, min: number, max: number): boolean {
//	if (!node) return true;
// 	if (node.val <= min || node.val >= max) return false;
//	return solve(node.left, min, node.val) && solve(node.right, node.val, max);
//}
