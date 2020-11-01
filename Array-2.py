# TC=O(N)
# SC=O(1)
# 1. for each value present in list,go to its respective index and multiply with -1.
# 2. the indexes with values greater than 0 are the missing indexes.
class Solution1:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        length=len(nums)
        result=[]
        if length== 0: return result
    
        
        for index in range(0,length,1):
            val=abs(nums[index])-1
            if nums[val]>0:
                nums[val]=-1*nums[val]
        
        for index in range(0,length,1):
            if nums[index]>0:
                result.append(index+1)
                
        return result








def countlives(board,i,j):
        row_len=len(board)
        col_len=len(board[0])
        dir=[[-1,-1],[-1,0],[-1,1],
             [0,-1],[0,1],
             [1,-1],[1,0],[1,1]           
            ]
        state=0
        for val in dir:
            r=i+val[0]
            c=j+val[1]

            if (r>=0) and(c>=0) and (r<row_len)and (c<col_len):
                if (board[r][c]==1 or board[r][c]==2):
                    state=state+1
        
        return state
    
    
class Solution:
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        row_len=len(board)
        col_len=len(board[0])
        result=[]
        # state change 0--->1 3
        # state change 1--->0 2
        for i_index in range(0,row_len):
            for j_index in range(0,col_len):
                
                state = countlives(board,i_index,j_index)
                
                if (board[i_index][j_index]==1) and (state<2 or state>3):
                        board[i_index][j_index]=2
                        
                if (board[i_index][j_index]==0) and (state==3):
                        board[i_index][j_index]=3
                   
        for i_index in range(0,row_len):
            for j_index in range(0,col_len):
                if (board[i_index][j_index]==2) :
                    board[i_index][j_index]=0
                elif (board[i_index][j_index]==3) :
                    board[i_index][j_index]=1
                        
                
                
        

		
		
		

		
