class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        indexs_change = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                neib = 0
                i_val = [i+1,i,i-1]
                j_val = [j+1,j-1,j]
                for i1 in i_val:
                    for j1 in j_val:
                        if i1 >= 0 and i1 < len(board) and j1 >= 0 and j1 < len(board[0]):
                            neib += board[i1][j1]
                neib -= board[i][j]
                if neib < 2 and board[i][j] == 1:
                    indexs_change.append((i,j))
                elif (neib == 2 or neib ==3) and board[i][j] == 1:
                    print("lives on to next",(i,j))
                elif neib > 3 and board[i][j] == 1:
                    indexs_change.append((i,j))
                elif neib == 3 and board[i][j] == 0:
                    indexs_change.append((i,j))
        # print(indexs_change)
        for index in indexs_change:
            if board[index[0]][index[1]] == 0:
                board[index[0]][index[1]] = 1
            else:
                board[index[0]][index[1]] = 0
            
        print(board)