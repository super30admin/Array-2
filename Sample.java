// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//448 Finding All the disappareard Numbers
class Solution(object):
    def findDisappearedNumbers(self, nums): //T.C -> O(N),S.C->O(N)
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[]
        for i in range(len(nums)): //changing the state 
            idx = abs(nums[i]) - 1 //getting abs value beacuse value is overwrite with -1
            if nums[idx] > 0:        //checking if it is already present or not 
                nums[idx] = nums[idx] * -1
        for i in range(len(nums)):  //finding all the non-negative nuber index and can determine which number is missing
            if nums[i] < 0:
                nums[i] = nums[i] * -1
            else:
                result.append(i+1)
        return result


//289. Game Of Life
class Solution(object):
    def gameOfLife(self, board): //T.C -> O(M*N), S.C -> O(1)
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        m = len(board) - 1
        n = len(board[0]) -1
                #left #right #up   #down #digLeftUp #right #downleft #downright
        dir = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.countTheLiveCell(board,dir,m,n,i,j)

                if board[i][j] == 0 or board[i][j] == 3:
                    if count == 3:
                        board[i][j] = 3 //dead to alive
                if board[i][j] == 1 or board[i][j] == 2:
                    if count < 2 or count > 3:
                        board[i][j] = 2 //alive to dead
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0
        return board
    def countTheLiveCell(self,board,dir,m,n,i,j):
        count = 0
        for direction in dir:
            r = i + direction[0]
            c = j + direction[1]
            
            if r < 0 or c < 0 or r > m or c > n:
                continue
            elif board[r][c] == 1 or board[r][c] == 2:
                count+=1
        return count
                    
//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

def minMax(nums):
    max_number = -99999999999
    min_number = 9999999999

    for i in range(len(nums)): //T.C -> O(N) S.C-> O(1)
        if i < len(nums)-1 and nums[i] < nums[i+1]:
            min_number = min(min_number,nums[i])
            max_number = max(max_number,nums[i+1])
        elif i < len(nums)-1 and nums[i] > nums[i+1]:
            min_number = min(min_number , nums[i+1])
            max_number = max(max_number,nums[i])
        else:
            min_number = min(min_number,nums[i])
            max_number = max(max_number , nums[i])
    return [min_number,max_number]

nums = [1,2,3,4,5]
answer = minMax(nums)
print(answer)




        
