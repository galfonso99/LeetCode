# Implement this from zero make sure to note this time that we are dealing with a BST search tree
class TreeNode:
    def __init__(self, val: int =0, left: 'TreeNode | None' =None, right: 'TreeNode | None'=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode | None', p: 'TreeNode | None', q: 'TreeNode | None') -> 'TreeNode | None':
        # if p bigger than q then swap them
        if not p or not q: return None
        if p.val > q.val:
            temp = p
            p = q
            q = temp
        while root:
            if root.val <= p.val and root.val >= q.val:
                return root
            elif root.val < p.val:
                root = root.right
            else:
                root = root.left
        return None

