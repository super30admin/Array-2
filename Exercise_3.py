# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The neighbor counting logic
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m=len(board)
        n=len(board[0])

        def get_nbs_count(i,j,board):
            nbs_count=0
            for x in range(max(0, i - 1), min(m, i + 2)):
                for y in range(max(0, j - 1), min(n, j + 2)):
                    if (x != i or y != j) and board[x][y] == 1 or board[x][y] == 2:
                        nbs_count+=1
            return nbs_count


        for i in range(m):
            for j in range(n):

                ones = get_nbs_count(i,j,board)
                if board[i][j] == 0 and ones == 3:
                    # 0 --> current state of cell, 3 --> next state of cell dead
                    board[i][j] = 3
                    
                elif board[i][j] == 1 and (ones < 2 or ones > 3):
                    # if cell is dead, set it alive in next state
                    # 1 --> cell is alive, set it alive in next state by marking --> 2
                    board[i][j] = 2

                    

        # Update the board to the next state
        # 0 --> dead, 1 --> alive, 2 --> dead in next state
        # 3 --> alive in next state
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

