#time complexity: O(m*n)
#space complexity : O(1)
#ran on leetcode: yes
#The problem is complicated by the fact that cells have to be converted from
#dead->live or live->dead and when this change happens for the neighboring cells 
#it is difficult to find out whether this cell used to be dead or live. To tackle this problem
#when a cell ahs to be change to live from dead, instead of giving 1, give it a value of 2. 
#similarly, from live->dead, give a value 3. While counting the number of live and dead cells
#among neighbrs, count live as 1 and 3, count dead as 0 and 2. Loop thorugh for a 2nd time to
#change all 3's to 0 and 2's to 1. 
class Solution:
    def count_livecell(self,i,j,board):
        up_l=(-1+i,-1+j)
        up=(-1+i,0+j)
        up_r=(-1+i,+1+j)
        l= (0+i,-1+j)
        r= (0+i,+1+j)
        ll=(+1+i,-1+j)
        d=(+1+i,0+j)
        lr=(+1+i,+1+j)
        count=0
        #3 -> originally live, now dead
        #print(up_l,l,up)

        if(up_l[0]>=0 and up_l[1]>=0 and board[up_l[0]][up_l[1]] in [1,3]):
            count+=1
        if(up[0]>=0 and board[up[0]][up[1]] in [1,3]):
            count+=1
        if(up_r[0]>=0 and up_r[1]<len(board[0]) and board[up_r[0]][up_r[1]] in [1,3]):
            count+=1
        if(l[1]>=0 and board[l[0]][l[1]] in [1,3]):
            count+=1
        if(r[1]<len(board[0]) and board[r[0]][r[1]] in [1,3]):
            count+=1
        if(ll[0]<len(board) and ll[1]>=0 and board[ll[0]][ll[1]] in [1,3]):
            count+=1
        if(d[0]<len(board) and board[d[0]][d[1]] in [1,3]):
            count+=1
        if(lr[0]<len(board) and lr[1]<len(board[0]) and board[lr[0]][lr[1]] in [1,3]):
            count+=1
        #print(count)
        return count

        


    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                count=self.count_livecell(i,j,board)
                if(board[i][j]==1):
                    if(count<2):
                        board[i][j]=3
                    if(count>3):
                        board[i][j]=3
                else:
                    if(count==3):
                        board[i][j]=2
        #print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(board[i][j]==3):
                    board[i][j]=0
                elif(board[i][j]==2):
                    board[i][j]=1
s=Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
s.gameOfLife(board)
print(board)
