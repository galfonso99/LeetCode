from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        solve(root, 0, ans)
        return ans
def solve(node: TreeNode, level: int, ans: List[int]):
    if not node: return
    if len(ans) == level: ans.append(node.val)
    solve(node.right, level+1, ans)
    solve(node.left, level+1, ans)
