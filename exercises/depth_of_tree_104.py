from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return self.depth(root, 0)
        
    def depth(self, node: Optional[TreeNode], height: int) -> int:
        if node is None:
            return height
        return max(self.depth(node.left, height+1), self.depth(node.right, height+1))

