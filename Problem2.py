#Time Complexity: O(m*n)
#Space complexity: O(1)

#Accepted on Leetcode

#Approach:
#For each index check it's adjacent 8 indices to determine what will happen to it
#If a given 1 changes to 0, mark it using a unique number. If a given 0 changes 1, mark it using a unique numbers
#Use these 'unique' numbers to know the 'previous value' of an index which has been changed (for computing future values)
#At the end once all the changes are completed, revert the unique numbers to the 'new values' whether 0 or 1

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        A = board
        n = len(A)
        m = len(A[0])

        # 0 --> 2 if changed to 1 else 0
        # 1 --> 3 if changed to 0 else 0
        for i in range(n):
            for j in range(m):
                liveCellCount = self.getLiveCellCount(A, i, j)
                if A[i][j] == 1: #alive
                    if liveCellCount < 2 or liveCellCount > 3:
                        A[i][j] = 3
                else: #dead
                    if liveCellCount == 3:
                        A[i][j] = 2

        for i in range(n):
            for j in range(m):
                if A[i][j] == 3:
                    A[i][j] = 0
                elif A[i][j] == 2:
                    A[i][j] = 1
        
        return liveCellCount

    def getLiveCellCount(self, A, i, j):
        dirs = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,+1],[+1,-1],[+1,+1],] #U D L R UL UR DL DR
        count = 0
        for dArr in dirs:
            rAdd = dArr[0]
            cAdd = dArr[1]
            checkRow = i + rAdd
            checkCol = j + cAdd
            if self.isValid(A, checkRow, checkCol) and (A[checkRow][checkCol] == 1 or A[checkRow][checkCol] == 3):
                count += 1
        return count

    def isValid(self, A, i, j):
        if i < len(A) and i >= 0 and j < len(A[0]) and j>=0:
            return True
        return False

        

