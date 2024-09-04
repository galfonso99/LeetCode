from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        is_balanced = self.height(root) != -1
        return is_balanced
    def height(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0
        left = self.height(node.left)
        right = self.height(node.right)

        if left == -1 or right == -1:
            return -1
        if abs(left - right) > 1:
            return -1
        return max(left, right) + 1
