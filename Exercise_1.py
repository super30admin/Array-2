class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        changeList = []
        
        for x in range(len(board)):
            for y in range(len(board[x])):
                eightSum = self.neighborEightSum(x, y, board)
                if board[x][y] == 1 and (eightSum < 2 or eightSum > 3):
                    changeList.append([x, y, 0])
                elif board[x][y] == 0 and eightSum == 3:
                    changeList.append([x, y, 1])
         
        for chnage in changeList:
           board[chnage[0]][chnage[1]] = chnage[2] 
                
                
    def neighborEightSum(self, x:int, y:int, board) -> int:            
        sum = 0
        for row in [x-1, x, x+1]:
            if row >= 0 and len(board)-1 >= row:
                sum += board[row][y-1] if y-1 >= 0 else 0
                sum += board[row][y] if row != x else 0
                sum += board[row][y+1] if len(board[row])-1 >= y+1 else 0
        
        return sum