import java.util.List;
import java.util.ArrayList;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) { return null; }
		var maximum_amount_of_unique_nodes = 101;
		var visited = new Node[maximum_amount_of_unique_nodes];
        cloneNode(node, visited);
        return visited[node.val];
    }

    private void cloneNode(Node node, Node[] visited) {
        Node clonedNode = new Node(node.val);
		visited[node.val] = clonedNode;
        for (Node neighbor : node.neighbors) {
            if (visited[neighbor.val] == null) {
                cloneNode(neighbor, visited);
            }
            visited[node.val].neighbors.add(visited[neighbor.val]);
        }
    }
}

