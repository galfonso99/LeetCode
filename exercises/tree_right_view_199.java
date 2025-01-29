import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

// Most optimized iterative solution (W/o queues)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            ans.add(currentLevel.get(currentLevel.size() - 1).val);
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            currentLevel = nextLevel;
        }
        
        return ans;
    }
}
// Good iterative solution inspired by the tree_level_traversal solution
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        if (root == null) return ans;
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			var levelSize = queue.size();
//			var right_val = 0; 
//			for (int i = 0; i < levelSize; i++) {
//				var node = queue.poll();
//				right_val = node.val;
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//			ans.add(right_val);
//		}
//		return ans;
//	}
//}
// Recursive solution
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        solve(root, 0, ans);
//        return ans;
//    }
//    void solve(TreeNode node, int level, List<Integer> ans) {
//        if (node == null) {
//			return;
//		}
//		if (ans.size() == level) ans.add(node.val);
//		else ans.set(level, node.val);
//		solve(node.left, level+1, ans);
//		solve(node.right, level+1, ans);
//    }
//}
// Different iterative solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> view = new ArrayList<>();
		if (root == null) { return ans; }
		var level = List.of(root);
		while (level.size() > 0) {
			view.add(level.get(level.size() - 1).val);
			List<TreeNode> new_level = List.of();
			for (var node : level) {
				if (node.left != null) new_level.add(node.left);
				if (node.right != null) new_level.add(node.right);
			}
			level = new_level;
		}
		return view;
	}
}



