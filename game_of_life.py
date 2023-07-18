class Solution:
    def check_neighbours(self,direction, board, i, j):
        cell=board[i][j]
        alive_neighbor=0
        dead_neighbor=0
        row=len(board)-1
        cols=len(board[0])-1
        print("***",board[i][j],(i,j),"***")
        for z in direction:
            new_i= i+z[0]
            new_j= j+z[1]
            if((new_i<0 or new_i>row) or (new_j<0 or new_j>cols )):
                continue
            print(new_i,new_j)
            if(board[new_i][new_j]%2):
                alive_neighbor+=1
            else:
                dead_neighbor+=1
        print("alive_neighbor= ",alive_neighbor)
        print("#############")
        return [dead_neighbor, alive_neighbor]

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        direction=[[-1,0],[0,1],[1,0],[0,-1],[-1,1],[1,1],[1,-1],[-1,-1]]
        rows=len(board)
        col=len(board[0])

        for i in range(rows):
            for j in range(col):
                count_list=self.check_neighbours(direction, board, i, j)
                if(board[i][j]%2):
                    if(count_list[1]<2):
                        board[i][j]=3
                    else:
                        if(count_list[1]==2 or count_list[1]==3):
                            continue
                        else:
                            if(count_list[1]>3):
                                board[i][j]=3
                else:
                    if(count_list[1]==3):
                        board[i][j]=2
        for i in range(rows):
            for j in range(col):
                if(board[i][j]==2):
                    board[i][j]=1
                else:
                    if(board[i][j]==3):
                        board[i][j]=0
                    
