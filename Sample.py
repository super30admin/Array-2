# Problem 1: Find all numbers disappeared in an array
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n=len(nums)
        for i in range(n):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1]*=-1
        res=[]
        for i in range(n):
            if nums[i]<0:
                nums[i]*=-1
            else:
                res.append(i+1)
        
        return res




# Problem 2: Game of life
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
    
        def countAlives(board, r, c):
            dirs=[(-1,0), (1,0), (0,-1), (0,1), (-1,-1), (-1,1), (1,-1), (1,1)]
            m=len(board)
            n=len(board[0])
            count=0
            for d in dirs:
                nr=r+d[0]
                nc=c+d[1]

                # Bound Check
                if (nr >=0 and nr < m ) and (nc>= 0 and nc < n) and (board[nr][nc]==1 or board[nr][nc]==5):
                    count+=1
            return count

        m=len(board)
        n=len(board[0])

        for i in range(m):
            for j in range(n):
                count=countAlives(board, i, j)
                if board[i][j]==1 and (count<2 or count>3):
                    board[i][j]=5
                if board[i][j]==0 and count==3:
                    board[i][j]=4
        

        for i in range(m):
            for j in range(n):
                if board[i][j]==5:
                    board[i][j]=0
                if board[i][j]==4:
                    board[i][j]=1
        



# Problem 3: Min and Max
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def minAndMax(arr):
    n=len(arr)

    if n%2==0:
        if arr[0]<arr[1]:
            mn=arr[0]
            mx=arr[1]
        else:
            mn=arr[1]
            mx=arr[0]

        i=2
    
    else:
        mn=mx=arr[0]
        i=1
    

    while (i<n-1):
        if arr[i]<arr[i+1]:
            mn=min(mn, arr[i])
            mx=max(mx, arr[i+1])
        else:
            mx=max(mx, arr[i])
            mn=min(mn, arr[i+1])
        i+=2
    
    return (mn, mx)

