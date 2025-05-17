// Original working solution
class Solution {
    public int countComponents(int n, int[][] edges) {
		boolean[] connected = new boolean[n];
		int component_count = 0;

		ArrayList<Integer>[] adj_list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj_list[i] = new ArrayList<Integer>();
        }   
		for (var edge : edges) {
			var e1 = edge[0];
			var e2 = edge[1];

			adj_list[e1].add(e2);
			adj_list[e2].add(e1);
		}

		for (int i = 0; i < n; i++) {
			if (!connected[i]) {
				dfs(adj_list, connected, i);
				component_count++;
			}
		}
		return component_count;
    }

	void dfs(ArrayList<Integer>[] adj_list, boolean[] connected, int i) {
		if (connected[i]) return;
        connected[i] = true;
		for (var neighbor : adj_list[i]) {
			dfs(adj_list, connected, neighbor);
		}
	}
}
