from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    Max = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.depth(root)
        return self.Max
    def depth(self, node: Optional[TreeNode]) -> int:
        if node is None:
            return 0
        left = self.depth(node.left)
        right = self.depth(node.right)

        self.Max = max(self.Max, left + right)

        return max(left, right) + 1
        
