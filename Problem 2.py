# Time: O(n*m)
# Space: O(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 0-> 1 = 2
        # 1 -> 0 = 3
        for i in range(len(board)):
            for j in range(len(board[0])):
                # print(i,j)
                one_count = 0
                zero_count = 0
                if i-1>=0:
                    if board[i-1][j] == 0 or board[i-1][j] == 2:
                        zero_count += 1
                    else:
                        one_count += 1
                if i+1 < len(board):
                    if board[i+1][j] == 0 or board[i+1][j] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                if j-1>=0:
                    if board[i][j - 1] == 0 or board[i][j - 1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                if j+1 < len(board[0]):
                    if board[i][j+1] == 0 or board[i][j+1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                if i-1>=0 and j-1 >=0:
                    if board[i-1][j-1] == 0 or board[i-1][j-1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                if i-1>=0 and j+1 < len(board[0]):
                    if board[i-1][j+1] == 0 or board[i-1][j+1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                        
                if i+1<len(board) and j-1 >=0:
                    if board[i+1][j-1] == 0 or board[i+1][j-1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                if i+1<len(board) and j+1<len(board[0]):
                    if board[i+1][j+1] == 0 or board[i+1][j+1] == 2:
                        zero_count+= 1
                    else:
                        one_count += 1
                # print(one_count, zero_count)
                # print('*'*50)
                if board[i][j] == 1 or board[i][j] == 3:
                    if one_count <2:
                        board[i][j] = 3
                    elif one_count >3:
                        board[i][j] = 3
                else:
                    if one_count ==3:
                        board[i][j] = 2
        # print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
        return board
                    
                
                    
                
        
