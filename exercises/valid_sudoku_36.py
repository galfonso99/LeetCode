from typing import List
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(len(board)):
            rows = set()
            cols = set() 
            boxes = set()
            for j in range(len(board[0])):
                row_ch = board[i][j]
                if row_ch != '.' and (row_ch in rows or rows.add(row_ch)):
                    return False
                col_ch = board[j][i]
                if col_ch != '.' and (col_ch in cols or cols.add(col_ch)):
                    return False
                row_index = (i // 3) * 3
                col_index = (i % 3) * 3

                box_ch = board[row_index + (j // 3)][col_index + (j % 3)]
                if box_ch != '.' and (box_ch in boxes or boxes.add(box_ch)):
                    return False
        return True

# Alternative Solution that is faster
# class Solution:
#     def isValidSudoku(self, board: List[List[str]]) -> bool:
#         rows = [set() for _ in range(9)]
#         cols = [set() for _ in range(9)]
#         boxes = [set() for _ in range(9)]
        
#         for r in range(9):
#             for c in range(9):
#                 num = board[r][c]
                
#                 if num == '.':
#                     continue
                
#                 box_index = (r // 3) * 3 + (c // 3)
                
#                 if num in rows[r] or num in cols[c] or num in boxes[box_index]:
#                     return False
                
#                 rows[r].add(num)
#                 cols[c].add(num)
#                 boxes[box_index].add(num)
        
#         return True