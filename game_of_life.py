class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        iterate the board cell one by one
        1. any live cell with fewer than two live neighbors or more than three live neighbors dies, change the value to -1
        2. cell with exactly three live neighbors becomes a live cell,, change the value to 2

        compute the value of the counter applying these rules, and hence proving live

        """

        def gameOfLifeInfinite(live):
            ctr = collections.Counter((I, J)
                                      for i, j in live
                                      for I in range(i - 1, i + 2)
                                      for J in range(j - 1, j + 2)
                                      if I != i or J != j)
            return {ij
                    for ij in ctr
                    if ctr[ij] == 3 or ctr[ij] == 2 and ij in live}

        live = {(i, j) for i, row in enumerate(board) for j, live in enumerate(row) if live}
        live = gameOfLifeInfinite(live)
        for i, row in enumerate(board):
            for j in range(len(row)):
                row[j] = int((i, j) in live)


'''
Complexity Analysis

Time Complexity: O(M×N), where M is the number of rows and N is the number of columns of the Board.

Space Complexity: O(1)

'''
