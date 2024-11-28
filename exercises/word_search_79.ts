// Most optimized solution
function exist(board: string[][], word: string): boolean {
    const dirs = [[0, -1], [1, 0], [0, 1], [-1, 0]];
    
    const rows = board.length;
    const cols = board[0].length;
    
       const charCount = new Array(128).fill(0);
   const start_coords: [number, number][] = [];

   for (let y = 0; y < rows; y++) {
       for (let x = 0; x < cols; x++) {
           charCount[board[y][x].charCodeAt(0)] += 1;
           if (board[y][x] === word[0]) {
               start_coords.push([x, y]);
           }
       }
   }

   for (const char of word) {
       charCount[char.charCodeAt(0)] -= 1;
       if (charCount[char.charCodeAt(0)] < 0) return false;
   }

   if (start_coords.length === 0) return false;
    
    function walk(x: number, y: number, idx: number): boolean {
        if (idx === word.length) return true;
       if (x < 0 || x >= cols || y < 0 || y >= rows) return false;
       if (board[y][x] !== word[idx]) return false;
        
        const curr = board[y][x];
        if (curr === '#' || curr !== word[idx]) return false;
        
        board[y][x] = '#';
        
        for (const [dx, dy] of dirs) {
            if (walk(x + dx, y + dy, idx + 1)) {
                return true;
            }
        }
        
        board[y][x] = curr;
        return false;
    }
    
    return start_coords.some(([x, y]) => walk(x, y, 0));
}
