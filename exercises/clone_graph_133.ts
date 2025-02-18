// IN THE OUTER FUNCTION
// null return null
// make heap array of 100 nodes
// call dfs with first node and visited array
// return the element from the array that corresponds to the index of the value of the first original node
//
// IN THE DFS
// clone the node
// add the cloned node to the array
// for each neighbor of node
// if its not in the visited array run dfs with current neighbor
// make the connection from copy node to copy node neighbor 


class _Node {
    val: number
    neighbors: _Node[]

    constructor(val?: number, neighbors?: _Node[]) {
        this.val = (val===undefined ? 0 : val)
        this.neighbors = (neighbors===undefined ? [] : neighbors)
    }
}

function cloneGraph(node: _Node | null): _Node | null {
	if (node == null) return null
	const max = 101
	const copied: (_Node|null)[] = new Array(max).fill(null)
	dfs(node, copied)
	return copied[node.val]
}

function dfs(node: _Node, copied: (_Node|null)[]) {
	const copy = new _Node(node.val)
	copied[node.val] = copy
	for (const neighbor of node.neighbors) {
		if (copied[neighbor.val] == null) {
			dfs(neighbor, copied)
		}
		copied[node.val]!.neighbors.push(copied[neighbor.val]!)
	}
}
