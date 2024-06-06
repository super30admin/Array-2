# TC - O(m*n)
# SC - O(1), no additional space used

# Approach

# add 2 in the matrix for those neighbours which will die in the next generation
# add 3 in the matrix for those neighbours which will live in the next generation
# create a direction list which contains elements with which every direction in the matrix can be covered.
# check for live neighbours using 1 or 2 and increment count

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return None

        lenRow = len(board)
        lenCol = len(board[0])
        rangeRow = range(lenRow)
        rangeCol = range(lenCol)

        for i in rangeRow:
            for j in rangeCol:

                countLive = self.countLiveN(board, i, j, lenRow, lenCol)

                if board[i][j] == 1:

                    if countLive < 2 or countLive > 3:
                        board[i][j] = 2

                else:
                    if countLive == 3:
                        board[i][j] = 3

        for i in rangeRow:
            for j in rangeCol:

                if board[i][j] == 2:
                    board[i][j] = 0

                if board[i][j] == 3:
                    board[i][j] = 1

    def countLiveN(self, board, iR, jC, lR, lC):

        dirElement = [[-1, -1], [-1, 0], [-1, 1],
                      [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        count = 0

        for i in range(len(dirElement)):

            nR = iR + dirElement[i][0]
            nC = jC + dirElement[i][1]

            if (nR >= 0 and nC >= 0 and nR < lR and nC < lC):
                if (board[nR][nC] == 1 or board[nR][nC] == 2):
                    count = count+1

        return count
