from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return not subRoot
        return self.isEqual(root, subRoot) or self.isSubtree(root.left, subRoot) \
               or self.isSubtree(root.right, subRoot) 

    def isEqual (self, a: Optional[TreeNode], b: Optional[TreeNode]) -> bool:
        if not a:
            return not b
        if not b:
            return False
        return a.val == b.val and self.isEqual(a.left, b.left) and self.isEqual(a.right, b.right)

# Alternative solution
# class solution:   
#     def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
#         return self.subtree(root, subRoot, subRoot)
#
#     def subtree (self, root: Optional[TreeNode], subRoot: Optional[TreeNode], currSub: Optional[TreeNode]) -> bool:
#         if not root:
#             return not currSub
#         if not currSub:
#             return False
#         if root.val == currSub.val and self.subtree(root.left, subRoot, currSub.left) \
#                             and self.subtree(root.right, subRoot, currSub):
#             return True
#         if root.val == subRoot and self.subtree(root.left, subRoot, subRoot.left) \
#                             and self.subtree(root.right, subRoot, subRoot.right):
#             return True
#         return self.subtree(root.left, subRoot, subRoot) or self.subtree(root.right, subRoot, subRoot)

