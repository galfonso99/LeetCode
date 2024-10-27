import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
// Improved version of my original solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}
// Solution using recursion normally I would side with this solution but I think
// It defeats the points of the question which is breath first traversal
// So instead I will try to refine my iterative solution
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        solve(root, ans, 0);
//        return ans;
//    }
//
//    public void solve(TreeNode root, List<List<Integer>> ans, int level) {
//        if (root == null)
//            return;
//        if (ans.size() == level)
//            ans.add(new ArrayList<>());
//        ans.get(level).add(root.val);
//        solve(root.left, ans, level + 1);
//        solve(root.right, ans, level + 1);
//    }
//}
// Original solution using iteration like it was intended I think
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		TreeNode leftmost_node = root;
		queue.add(root);
		while (!queue.isEmpty()) {
			var node = queue.poll();
            if (node == leftmost_node) {
				ans.add(new LinkedList<Integer>());
				leftmost_node = null;
			}
			ans.get(ans.size() - 1).add(node.val);
			if (node.left != null) {
                queue.add(node.left);
                if (leftmost_node == null) leftmost_node = node.left;
            }
			if (node.right != null) {
                queue.add(node.right);
                if (leftmost_node == null) leftmost_node = node.right;
            }
		}
		return ans;
    }
}
