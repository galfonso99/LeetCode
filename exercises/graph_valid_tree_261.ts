// Really fast one pass
function validTree(n: number, edges: number[][]): boolean {
	const depths: number[] = new Array(n).fill(0);
	depths[0] = 1;

	for (const edge of edges) {
		let e1 = edge[0];
		let e2 = edge[1];

		if (depths[e1] === 0 && depths[e2] !== 0) {
			const tmp = e2;
			e2 = e1;
			e1 = tmp;
		}
		if (depths[e1] === 0) 
			return false;
		if (depths[e2] !== 0 && depths[e1] + 1 !== depths[e2]) 
			return false;
		if (depths[e2] === 0) 
			depths[e2] = depths[e1] + 1;
	}
	return true;
}
