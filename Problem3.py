# // Time Complexity :O(MXN)
# // Space Complexity :o(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

# https://leetcode.com/problems/game-of-life/description/
# // Your code here along with comments explaining your approach
# keep track of whats alive and dead but that should not effect others, 2 good things are functions and directions
class Solution:
    def gameOfLife(self, mat: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #[m][n]
        def countAlives(i_o,j_o,mat):
             #returns cont, counting lives i.e 1's/ 5's
             c=0
             #[m][n] #[i][j]
             m,n=len(mat),len(mat[0])
             dir=[[-1,0],[1,1],[0,1],[1,0],[-1,-1],[0,-1],[-1,1],[1,-1]]
             for d in dir:
                i,j=i_o+d[0],j_o+d[1]
                if 0<=i<m and 0<=j<n:
                    if mat[i][j]==1 or mat[i][j]==5:
                        c+=1
             print(c)
             return c

        m,n=len(mat),len(mat[0])
        #4 0->1 ,5 1->0
        for i in range(m):

            for j in range(n):
                count=countAlives(i,j,mat)

                if mat[i][j]==1 and count<2:
                    mat[i][j]=5
                elif mat[i][j]==1 and count>3:
                    mat[i][j]=5
                elif mat[i][j]==0 and count==3:
                    mat[i][j]=4
        #changes done ..now change orginal mat
        for i in range(m):
            for j in range(n):
                if mat[i][j]==4:
                    mat[i][j]=1
                elif mat[i][j]==5:
                    mat[i][j]=0
        


                 
