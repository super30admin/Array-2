'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)

- traverse the array and treat the indexes as numbers present in the array by multiplying the element at index 'nums[i]'
- check if nums[i] is already negative, if negtive, get the index by multiplying by -1
- at the end, keep adding the indexes in result array where nums[i] is positive

'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result=[]
        
        for i in range(0, len(nums)):
            temp=nums[i]
            if  temp <0:
                temp*=-1
            if nums[temp-1]>0:
                nums[temp-1]*=-1
        
        for i in range(0,len(nums)):
            if nums[i]>0:
                result.append(i+1)
                
        return result


'''
PROBLEM 2

TIME COMPLEXITY: O(m*n)
SPACE COMPLEXITY: O(1)

- traverse the array and calculate the live cells around every element board[i][j]
- apply the conditions mentioned in the problem depending on if board[i][j] is 0 or 1, change the values to temporary values in order to maintain previous value
- revert the temporary values back to 0 and 1

'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions= [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,1],[1,0],[1,-1]]
        
        # 1->0:3
        # 0->1:2

        for i in range(0,len(board)):
            for j in range(len(board[0])):
                live=0
                
                for d in directions:
                    if 0 <= i+d[0] < len(board) and 0<=j+d[1]<len(board[0]):
                        if board[i+d[0]][j+d[1]]==1 or board[i+d[0]][j+d[1]]==3:
                            live+=1
                
                if board[i][j]==1:
                    if live<2:
                        board[i][j]=3
                    if live>3:
                        board[i][j]=3
                        
                elif board[i][j]==0:
                    if live==3:
                        board[i][j]=2
        
                
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=1
                if board[i][j]==3:
                    board[i][j]=0
                    
                