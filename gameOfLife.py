class Solution:
    def counterAlive(self, nums: List[list[int]], r: int, c: int) -> int:
        dir_array = [
            (1, 0),
            (-1, 0),
            (0, 1),
            (0, -1),
            (1, 1),
            (1, -1),
            (-1, -1),
            (-1, 1),
        ]
        count = 0
        for i, j in dir_array:
            nr = r + i
            nc = c + j
            if (
                nr >= 0
                and nc >= 0
                and nr < len(nums)
                and nc < len(nums[0])
                and (nums[nr][nc] == 1 or nums[nr][nc] == -1)
            ):
                count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        """
        temp states: 
        record 1 - > 0 as -1 
        record 0 - > 1 as -2 
        """
        # store a direction array to go to all neighbours of a given element with respect to the row and col index shifts
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            for j in range(cols):
                count = self.counterAlive(board, i, j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = -2
                elif board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = -1
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == -2:
                    board[i][j] = 1
