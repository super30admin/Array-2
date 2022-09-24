#time complexity: o(m*n) where m and n are size of matrix
#space complexity: 
#passed all cases on LeetCode: yes
#difficulty faced:-
# comments:in the code
#https://leetcode.com/problems/game-of-life
class Solution:
    def gameOfLife(self, board: 'List[List[int]]') -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        #1->0 then 2
        #0->1 then 3
        
        def countneighbors(board,i,j):
            count = 0
            #this is a direction array to check all the 8 neighbors in diff direction:
            #example: 0,1 reprsents element at col+1 and same row
            #-1,-1 is UL element
            #we add this dir to element and check if it is 1
            dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
            for dir1 in dirs:
                nr = i + dir1[0]
                nc = j + dir1[1]
                if(nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                    count+=1
                
            return count
        
        for i in range(0,m):
            for j in range(0,n):
                neighbors = countneighbors(board, i , j)
                #print(neighbors)
                #this means curr ele is live or 1
                if (board[i][j] == 1):
                    #store 2 to remember if 1 has to be changed to 0, if cond is from one of the rules
                     if(neighbors < 2 or neighbors > 3):
                        board[i][j] = 2 
                #this means curr ele is dead or 0        
                else:
                    #store 3 to remember 0 has to be changed to 1, if cond is one of the rules
                    if(neighbors == 3):
                        board[i][j] = 3
                        
        #remember to change 2s stored above to 0 and 3s to 1       
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board
            
                
                
                