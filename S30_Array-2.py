# Find All Numbers Disappeared in an Array_Solution_Q1

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums==0 or len(nums) ==0:
            return 0
        
        result = []

        for i in range(len(nums)):
            index= abs(nums[i]) -1
            if nums[index] >0:
                nums[index] = nums[index] * -1

        for i in range(len(nums)):
            if nums[i] >0:
                result.append(i+1)
            else:
                nums[i]= nums[i] * -1
        return result  

#TC: O(n)
#SC: O(1)


---------------------------------------------------------------------------------------------------------------------------------
# Game of Life_Solution_Q2

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m= len(board)
        n= len(board[0]) #length of first row
        # 1->0 ==2 died
        # 0->1 ==3 alive

        for i in range(m):
            for j in range(n):
                liveNeigh= self.liveNeighborCount(board, i, j)
                if board[i][j]== 1:
                    if liveNeigh < 2 or liveNeigh > 3:
                        board[i][j]= 2
                else:
                    if liveNeigh ==3:
                        board[i][j]=3

        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1

    def liveNeighborCount(self, board: List[List[int]], r: int, c: int) -> int:
        count = 0
        m= len(board)
        n= len(board[0])
        dirs =[[-1,0], [1,0],[0,1],[0,-1],[-1,-1],[-1,1],[1,-1],[1,1]]
        for dir in dirs:
            nr= r+ dir[0]
            nc= c+ dir[1]
            if nr >=0 and nc >=0 and nr< m and nc< n and (board[nr][nc]==1 or board[nr][nc]==2):
                count = count +1
        return count

#TC: O(mn)
#SC: O(1)