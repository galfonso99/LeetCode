# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    count = 0
    def goodNodes(self, root: TreeNode) -> int:
        if not root: return 0
        self.solve(root, root.val)
        return self.count
    def solve(self, node, max):
        if node.val >= max: 
            self.count+=1
            max = node.val
        if node.left: self.solve(node.left, max)
        if node.right: self.solve(node.right, max)
