import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// DFS Solution (More recursive and easier to write)
class Codec {
    private String[] values;
    private int currentIndex;
    
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        serializeHelper(root, result);
        return String.join(",", result);
    }
    
    private void serializeHelper(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("N");
            return;
        }
        result.add(String.valueOf(node.val));
        serializeHelper(node.left, result);
        serializeHelper(node.right, result);
    }
    
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) { return null; }
        this.values = data.split(",");
        this.currentIndex = 0;
        return deserializeHelper();
    }
    
    private TreeNode deserializeHelper() {
        if (currentIndex >= values.length) { return null; }
        String currentValue = values[currentIndex];
        currentIndex++;
        if (currentValue.equals("N")) { return null; }
        TreeNode node = new TreeNode(Integer.parseInt(currentValue));
        node.left = deserializeHelper();
        node.right = deserializeHelper();
        return node;
    }
}

// Original passing Solution BFS Solution (Like how it is displayed in LeetCode)
// class Codec {
//     public String serialize(TreeNode root) {
// 		StringBuilder sb = new StringBuilder();
// 		Queue<TreeNode> queue = new LinkedList<>();
// 		queue.add(root);
// 		while (queue.size() != 0) {
// 			var curr = queue.poll();
// 			if (curr == null) {sb.append("N,"); continue;}
// 			sb.append("" + curr.val + ",");
// 			queue.add(curr.left);
// 			queue.add(curr.right);
// 		}
//
//         sb.deleteCharAt(sb.length() - 1);
// 		return sb.toString();
//     }
//
//     public TreeNode deserialize(String data) {
//         if (data == null || data.isEmpty()) return null;
//         String[] values = data.split(",");
//         int index = 0;
//         TreeNode root = parseNode(values[index++]);
//         if (root == null) return null;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//
//         while (!queue.isEmpty() && index < values.length) {
//             TreeNode curr = queue.poll();
//             if (index < values.length) {
//                 curr.left = parseNode(values[index++]);
//                 if (curr.left != null) {
//                     queue.add(curr.left);
//                 }
//             }
//             if (index < values.length) {
//                 curr.right = parseNode(values[index++]);
//                 if (curr.right != null) {
//                     queue.add(curr.right);
//                 }
//             }
//         }
//         return root;
//     }
//
//     private TreeNode parseNode(String value) {
//         return value.equals("N") ? null : new TreeNode(Integer.parseInt(value));
//     }
// }

