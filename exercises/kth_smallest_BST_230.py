class Solution:
    count: int = 0
    result: int | None = None
    def kthSmallest(self, root: TreeNode | None, k: int) -> int:
        self.solve(root, k)
        return self.result

    def solve(self, node: TreeNode | None, k: int):
        if not node: return
        self.solve(node.left, k)
        if self.result is not None: return
        self.count += 1
        if self.count == k: self.result = node.val
        self.solve(node.right, k)

