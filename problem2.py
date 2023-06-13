#the code has a time complexity of O(rows * columns) and a space complexity of O(1).
class Solution:
    def countLiveCells(self, i: int, j: int, board: List[List[int]]) -> int:
     directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
     i_bou= len(board)-1
     j_bou= len(board[0])-1
     print(i_bou,j_bou)
     count = 0
     for a, b in directions:
         print("outside:",i+a,j+b)
         print(i+a<=i_bou and i+a>=0 and  j+b<=j_bou and j+b>=0)
         
         if i+a<=i_bou and i+a>=0 and  j+b<=j_bou and j+b>=0 and  (board[i+a][j+b] == 1 or board[i+a] [j+b] == 2):
            print("inside:",i+a,j+b)
            count += 1

     return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows= len(board)
        columns= len(board[0])

        for i in range(rows):
          for j in range(columns):
            liveCells=self.countLiveCells(i,j,board)
            if(board[i][j]==1):
             if(liveCells<2):
                board[i][j]=2
             elif(liveCells > 3):
                 board[i][j]=2
            else:
                if(liveCells == 3):
                    board[i][j]=3
        for i in range(rows):
         for j in range(columns):
            if(board[i][j]==2):
                board[i][j]=0
            if(board[i][j]==3):
                board[i][j]=1
