// Rec Solution with nested function
function kthSmallest(root: TreeNode | null, k: number): number {
    let count = 0; 
    let result: number | null = null; 
    const traverse = function(node: TreeNode | null) {
        if (node === null || result !== null) return; 
        traverse(node.left);
        count++;
        if (count === k) {
            result = node.val; 
            return; 
        }
        traverse(node.right);
    };
    traverse(root);
    return result!;
};
// Iter Solution
//function kthSmallest(root: TreeNode | null, k: number): number {
//	if (!root) return -1;
//	const stack: TreeNode[] = [];
//	while (root) {
//		stack.push(root);
//		root = root.left;
//	}
//	while (k !== 0) {
//		const node = stack.pop()!;
//		k--;
//		if (k === 0) return node.val;
//		let right = node.right;
//		while (right) {
//			stack.push(right);
//			right = right.left;
//		}
//	}
//	return -1;
//}
