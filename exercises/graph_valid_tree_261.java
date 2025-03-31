import java.util.Arrays;
class Solution {
    public boolean validTree(int n, int[][] edges) {
		int[] depths = new int[n];
		depths[0] = 1;
		for (var e : edges) {
			if (depths[e[0]] == 0 && depths[e[1]] != 0)
				swap(e, 0, 1);
			if (depths[e[0]] == 0) 
				return false;
			if (depths[e[1]] != 0 && depths[e[0]] + 1 != depths[e[1]]) 
				return false;
			if (depths[e[1]] == 0) 
				depths[e[1]] = depths[e[0]] + 1;
		}
		return true;
    }

	void swap(int[] arr, int ind1, int ind2) {
		var tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}
}

// Theoretically for a graph to be a valid tree it have to be a undirected graph
// that is connected (cant be disconnected) and has no cycles
//
// Practically, I would say that for it to be a valid tree it has to be true that
// for each node to node connection the depth of the former node that to be strictly
// ONE LESS than the latter node unless the latter node does not have a depth yet
// in which case that is still valid
