# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
#Time Complexity=O(n)
#Space Complexity=O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            a=abs(nums[i])-1
            if nums[a]>0:
                nums[a]*=-1
        b=[]
        for i in range(1,len(nums)+1):
            if nums[i-1]>0:
                b.append(i)
        return b
## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

## Problem3 (https://leetcode.com/problems/game-of-life/)
#Time Complexity=O(n*m)
#Space Complexity=O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def check(board,row,col):
            r=len(board)
            c=len(board[0])
            cco=0
            ne=[(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,-1),(1,-1),(-1,1)]
            for i in ne:
                nr=row+i[0]
                nc=col+i[1]
                if (nr>=0 and nr<r) and (nc>=0 and nc<c):
                    if board[nr][nc]==1 or board[nr][nc]==9:
                        cco+=1
            return cco
                    
        #1-->0=9
        #0-->1=10
        for i in range(len(board)):
            for j in range(len(board[0])):
                l=check(board,i,j)
                print(l)
                if board[i][j]==1:
                    if l<2 or l>3:
                        board[i][j]=9
                elif board[i][j]==0:
                    #print(l)
                    if l==3:
                        board[i][j]=10
                        print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==9:
                    board[i][j]=0
                if board[i][j]==10:
                    board[i][j]=1
        return board
                    
            
