class Solution:
  def inorderTraversal(self, root: Optional[TreeNode], arr: list[int]) -> None:
    if root.left:
      self.inorderTraversal(root.left, arr)
    arr.append(root.val)
    if root.right:
      self.inorderTraversal(root.right, arr)

  def isValidBST(self, root: Optional[TreeNode]) -> bool:
    arr = []
    self.inorderTraversal(root, arr)
    for i in range(len(arr) - 1):
      if arr[i] >= arr[i + 1]:
        return False
    return True
