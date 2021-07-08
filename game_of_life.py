"""
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Trying to come with intuitve soln of
negative indexing

// Your code here along with comments explaining your approach
Algorithm Explanation
In the comments
"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        1. Set m, n
        2  Initiate results = []
        3. Iterate over the board and check for all 8 directions
        4. Count the live and dead in these 8 directions(if the direction exist)
        5. If the board member is live then
            if live count > 3 or live count < 2 then add [i,j,0] to results
        6. If the board member is dead then
            if live count is equal to 3 then add [i,j,1] to results
        7. Update the board values from the results array
        """
        def neighbours_ld(row,col,m,n):
            n_set = set([(row-1,col-1),(row+1,col+1),(row-1,col),(row-1,col+1),
                 (row,col-1),(row+1,col),(row,col+1),(row+1,col-1)])
            l = []
            print("n_set",n_set)
            for i in n_set:
                if i[0] < 0 or i[0] >=m or i[1] < 0 or i[1] >=n:# or visited[i[0]][i[1]] == 1:
                    #n_set.remove(i)
                    continue
                l.append((i[0],i[1]))
            
            print("L",l)
            live_cnt = 0
            dead_cnt = 0
            for i in l:
                r = i[0]
                c = i[1]
                if board[r][c] == 1:
                    live_cnt+=1
                if board[r][c] == 0:
                    dead_cnt+=1
            return live_cnt,dead_cnt
        
        m = len(board)
        n = len(board[0])
        #visited = [[0 for j in range(n)] for i in range(m)]
        results = []
        for i in range(m):
            for j in range(n):
                live,dead = neighbours_ld(i,j,m,n)
                #print(visited)
                print("LD",live,dead,i,j)
                if board[i][j] == 0: #dead
                    if live == 3:
                        print("update to live")
                        results.append([i,j,1])
                        #board[i][j] = 1
                        #visited[i][j] = 1
                if board[i][j] == 1: #live
                    if live > 3 or live < 2:
                        print("update to dead")
                        #board[i][j] = 0
                        results.append([i,j,0])
                        #visited[i][j] = 1
        
        for i in results:
            board[i[0]][i[1]] = i[2]