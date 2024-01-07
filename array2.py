# LeetCode 448
class Solution(object):
    def findDisappearedNumbers(self, nums):
        index = 0
        ans = []
        while index < len(nums):
            if nums[index] > 0:
                check = nums[index] - 1
            else:
                check = (-1 * nums[index]) - 1
            if nums[check] > 0:
                nums[check] *= -1
            index += 1
        index = 0
        while index < len(nums):
            if nums[index] > 0:
                ans.append(index + 1)
            index += 1
        return ans
        
# LeetCode 289

class Solution(object):
    directionsOfNeighbors = [[0,-1], [0,1], [-1,0], [1,0], [-1,-1], [-1,1], [1,1], [1,-1]]
    def checkNeighbors(self, i,j, board):
        index = 0
        alive = 0
        while index < len(self.directionsOfNeighbors):
            i1 =  i + self.directionsOfNeighbors[index][0]
            j1 = j + self.directionsOfNeighbors[index][1]
            if i1 >= 0 and j1 >= 0 and i1 < len(board) and j1 < len(board[0]) and (board[i1][j1] == 1 or board[i1][j1] == -10):
                alive += 1
            index += 1
        return alive
    def gameOfLife(self, board):
        i = 0
        while i < len(board):
            j = 0
            while j < len(board[0]):
                alive = self.checkNeighbors(i,j, board)
                if board[i][j] == 1 and (alive < 2 or alive > 3):
                    board[i][j] = -10
                if board[i][j] == 0 and alive == 3:
                    board[i][j] = 10
                j += 1
            i += 1
        i = 0
        while i < len(board):
            j = 0
            while j < len(board[0]):
                if  board[i][j] == -10:
                    board[i][j] = 0
                if  board[i][j] == 10:
                    board[i][j] = 1
                j += 1
            i += 1
        return board