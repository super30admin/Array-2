#Time Complexity : O(mn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        # define 6 states
        #
        #  0 .... current dead, next undefined
        #  1 .... current live, next undefined
        #  2 .... current dead, next dead
        #  3 .... current live, next live
        #  4 .... current dead, next live
        #  5 .... current live, next dead
        
        
        ny = len(board)
        nx = len(board[0])
        
        dir = [ [1,0], [-1,0], [1,1], [0,1], [-1,1], [1,-1], [0,-1], [-1,-1] ]
        
        def IsInside(y,x) :
            return 0<=y<ny and 0<=x<nx
        def IsCurrentAlive(y,x) :
            return board[y][x] == 1 or board[y][x] == 3 or board[y][x] == 5
        def IsNextAlive(y,x) :
            return board[y][x] == 2 or board[y][x] == 5
        
        for ix in range(nx) :
            for iy in range(ny) :
                
                # count number of neighbor live
                count = 0
                for dy,dx in dir :
                    if IsInside( iy+dy, ix+dx ) :
                        if IsCurrentAlive( iy+dy, ix+dx ) :
                            count += 1
                            
                # dead or alive?
                if IsCurrentAlive(iy,ix) :
                    if 2<=count<=3 :
                        board[iy][ix] = 3
                    else :
                        board[iy][ix] = 5
                else :
                    if count==3 :
                        board[iy][ix] = 4
                    else :
                        board[iy][ix] = 2

        # post processing
        for ix in range(nx) :
            for iy in range(ny) :
                if IsNextAlive(iy,ix) :
                    board[iy][ix] = 0
                else :
                    board[iy][ix] = 1