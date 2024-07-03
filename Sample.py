############448. Find All Numbers Disappeared in an Array###############################################################################################################################
// Time Complexity : n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : first I coded using hashes to save al values and loop through it to find the missing value but after class learnt way to play with array itself


// Your code here along with comments explaining your approach in three sentences only
We will iterate through the array and as per the stored value we will update the index by multiplying with -1 so the index which is positive is the missing number and all negative are the numbers which are present	


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        l1=[]
        for i in nums:
            #print(i,nums[i-1])
            nums[abs(i)-1]=abs(nums[abs(i)-1])*(-1)
            #print(nums)
        #print(nums)
        for i,val in enumerate(nums):
            if val <0:
                nums[i]=nums[i]*(-1)
            else:
                l1.append(i+1)
        return l1

        

###########289. Game of Life##############################################################################################################################


// Time Complexity : mXn
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : first I coded using another matrix where I stored net phase but post class I understood how it could be done in same matrix


// Your code here along with comments explaining your approach in three sentences only
Go through each element and check if in next phase it can be alive or dead on that basis updated cell to 3 if it moving for dead to alive and 4 in case it is alive to dead now while counting neighbor we can keep a track of old phase using 3 and 4

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        cols=len(board[0])
        for i in range(rows):
            for j in range(cols):
                alive=self.nxtstp(board,i,j,rows,cols)
                if alive<2 and board[i][j]==1:
                    board[i][j]=4
                if alive>3 and board[i][j]==1:
                    board[i][j]=4
                if alive==3 and board[i][j]==0:
                    board[i][j]=3
        for i in range(rows):
            for j in range(cols):
                if board[i][j]==3:
                    board[i][j]=1
                if board[i][j]==4:
                    board[i][j]=0
        
    def nxtstp(self,board,i,j,rows,cols): # function to calculate alive neighbors
        # 0 -> 1 3
        # 1 -> 0 4
        ngh=0
        dirarr=[[0,1],[1,0],[-1,0],[0,-1],[-1,-1],[1,1],[-1,1],[1,-1]]
        for r,c in dirarr:
            #print(r,c)
            rn=i+r
            cn=j+c
            if (rn>=0 and rn<rows) and (cn>=0 and cn<cols):
                if board[rn][cn]==1 or board[rn][cn]==4:	# checked for number 3 and 4
                    ngh+=1
        return ngh
        #print(i,j,ngh)


        


##########https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/###################################################################################################################


// Time Complexity : n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 1st coded my way thank coded as per class which reduced O(n) to 1.5N


// Your code here along with comments explaining your approach in three sentences only
#in my way I appended extra character at end and iterated through each element comparing with 1st and last element in way that 1st element is smaller and last element is largest and at end the smallest value will be present in 0th index and max value will be present in last index
# in class it was taught to take 2 element at a time and compare themselves to check which is smallest and than we compared smaller with min and larger one with max and we did this task till end off array


##my way uses 2n comparison
class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        nums.append(0)
        for i in nums:
            if i<=nums[0]:
                nums[0]=i
            if i>=nums[-1]:
                nums[-1]=i
        print(nums)
        print(nums[0],nums[-1])
        #return -1
        



##in class, the comparisons were dropped to 1.5n

class Solution:
    def findMinMax(self, nums: List[int]) -> int:
        min1=9999
        max1=0
        for i in range(0,len(nums),2):
            if nums[i]<nums[i+1]:
                min1=min(nums[i],min1)
                max1=max(nums[i+1],max1)
            else:
                min1=min(nums[i+1],min1)
                max1=max(nums[i],max1)
        print(min1,max1)

        #return -1
        
        
        




  