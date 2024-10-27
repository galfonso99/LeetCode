import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			var levelSize = queue.size();
			var right_val = 0; 
			for (int i = 0; i < levelSize; i++) {
				var node = queue.poll();
				right_val = node.val;
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			ans.add(right_val);
		}
		return ans;
	}
}
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
// Weird iterative solution
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//		ArrayList<Integer> view = new ArrayList<>();
//		if (root != null) {
//			var level = List.of(root);
//			while (level.size() > 0) {
//				view.add(level.get(level.size() - 1).val);
//				List<TreeNode> new_level = List.of();
//				for (var node : level) {
//					if (node.left != null) new_level.add(node.left);
//					if (node.right != null) new_level.add(node.right);
//				}
//				level = new_level;
//			}
//		}
//		return view;
//	}
//}
// Improvement to the weird iterative solution
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//		ArrayList<Integer> view = new ArrayList<>();
//		if (root == null) return view;
//        var level = new ArrayList<TreeNode>();
//        level.add(root);
//        var previous_size = 0;
//        var current_size = 1;
//        while (true) {
//            view.add(level.getLast().val);
//            for (int i = previous_size; i < current_size; i++) {
//                var node = level.get(i);
//                if (node.left != null) level.add(node.left);
//                if (node.right != null) level.add(node.right);
//            }
//            if (current_size == level.size()) break;
//            previous_size = current_size;
//            current_size = level.size();
//        }
//		return view;
//	}
//}



