// Optimal Solution using stop param
function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
	let i = 0;
    let p = 0;
	function solve(preorder: number[], inorder: number[], stop: number): TreeNode | null {
		if (p >= preorder.length) return null;
		if (inorder[i] === stop) { i += 1; return null; }
		const node = new TreeNode(preorder[p]);
		p += 1;
		node.left = solve(preorder, inorder, node.val);
		node.right = solve(preorder, inorder, stop);
		return node;
	}

	return solve(preorder, inorder, -Infinity);
};

// Original Solution not optimal using hashmap
//function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
//    let pre = 0;
//	const map = new Map();
//	function solve(preorder: number[], inorder: number[], start: number, end: number) {
//		if (start == end) return null;
//		const ind = map.get(preorder[pre]);
//		pre += 1;
//		const node = new TreeNode(inorder[ind]);
//		node.left = solve(preorder, inorder, start, ind);
//		node.right = solve(preorder, inorder, ind + 1, end);
//		return node;
//	}
//	// Build map and call helper function
//	for (let i = 0; i < inorder.length; i++) {
//		map.set(inorder[i], i);
//	}
//	return solve(preorder, inorder, 0, preorder.length);
//};

