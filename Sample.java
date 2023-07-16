// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        # multiplying by -1 if we find the element
        for i in range(n):
            idx = abs(nums[i]) - 1 
            if(nums[idx]>0):
                nums[idx]*=(-1)

        # adding in result if the value is positive, which is disappeared
        for i in range(n):
            if(nums[i]>0):
                res.append(i+1)
            else:
                nums[i]*=(-1)
        
        return res


// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    # 2 : 1-> 0
    # 3 : 0-> 1
    def countAlive(self,board: List[List[int]],i:int,j:int,m:int,n:int):
               #right left   top   down  lefttop righttop leftbot rightbot
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1], [1,-1], [1,1]]
        count = 0
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            if(r>=0 and c>=0 and r<m and c<n and (board[r][c]==2 or board[r][c]==1)):
                count+=1 
        return count
                

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                cnt = self.countAlive(board,i,j,m,n)
                if(board[i][j]==1 and (cnt<2 or cnt>3)):
                    board[i][j]=2
                if(board[i][j]==0 and cnt==3):
                    board[i][j]=3
        
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==3):
                    board[i][j]=1
        
        
