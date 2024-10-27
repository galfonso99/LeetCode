from typing import List, Optional
from queue import Queue
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        queue = Queue[TreeNode](0)
        ans = []
        queue.put(root)
        while not queue.empty():
            levelSize = queue.qsize()
            currentLevel = []
            for i in range(levelSize):
                node = queue.get()
                currentLevel.append(node.val)
                if node.left: queue.put(node.left)
                if node.right: queue.put(node.right)
            ans.append(currentLevel)
        return ans

# Recursive solution
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         ans = [] # create the List 
#         rec(root, 0, ans) # call rec
#         return ans
#
# def rec(node: TreeNode, level: int, ans: List[List[int]]):
#     if not node: return
#     if len(ans) == level: ans.append([])
#     ans[level].append(node.val)
#     rec(node.left, level+1, ans)
#     rec(node.right, level+1, ans)

