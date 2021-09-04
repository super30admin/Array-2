# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class GameOfLife:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        nbrs = [[0, 1], [-1, 1], [-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1]]
        for ind1 in range(len(board)):
            for ind2 in range(len(board[0])):
                count = self.get_nbr_count(board, ind1, ind2, nbrs)
                if board[ind1][ind2] == 0:
                    if count == 3:
                        board[ind1][ind2] = 2
                else:
                    if count < 2:
                        board[ind1][ind2] = 3
                    elif count > 3:
                        board[ind1][ind2] = 3
        for ind1 in range(len(board)):
            for ind2 in range(len(board[0])):
                if board[ind1][ind2] == 2:
                    board[ind1][ind2] = 1
                elif board[ind1][ind2] == 3:
                    board[ind1][ind2] = 0

    def get_nbr_count(self, board, ind1, ind2, nbrs):
        nbr_count = 0
        for nbr in nbrs:
            if 0 <= ind1 + nbr[0] < len(board) and 0 <= ind2 + nbr[1] < len(board[0]) and board[ind1 + nbr[0]][ind2 + nbr[1]] % 2 == 1:
                nbr_count += 1
        return nbr_count