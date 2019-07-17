class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # Idea: Check the 8 directions and count the live neighbours. 
        # 2. To do it in-place, mark the live element as -1 when it will dead in final state. 
        # 3. Mark dead cell as -2 if it will be live in the final state.
        
        # Time Complexity: O(M*N)
        # Space Complexity: O(1)
        for i in range(len(board)):
            for j in range(len(board[0])):
                live_neighbours = self.countLiveNeighbours(board,i,j)
                if board[i][j] == 1:
                    if (live_neighbours < 2 or live_neighbours > 3):
                            board[i][j] = -1
                    else:
                            board[i][j] = 1
                else:
                     if live_neighbours == 3:
                            board[i][j] = -2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == -1:
                        board[i][j] = 0
                else:
                    if board[i][j] == -2:
                        board[i][j] = 1

    def countLiveNeighbours(self,board,curr_row_idx,curr_col_idx):
        live_neighbours = 0
        directions = [(-1,0),(0,-1),(1,0),(0,1),(-1,-1),(1,-1),(1,1),(-1,1)]
        for direction in directions:
            row_idx = curr_row_idx + direction[0]
            col_idx = curr_col_idx + direction[1]
            if row_idx >= 0 and row_idx < len(board) and col_idx >= 0 and col_idx < len(board[0]) and board[row_idx][col_idx] != -2:
                    live_neighbours += abs(board[row_idx][col_idx])
        return live_neighbours
